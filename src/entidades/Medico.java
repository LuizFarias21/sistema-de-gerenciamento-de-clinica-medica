package entidades;

import excecoes.EspecialidadeInvalidaException;
import excecoes.HorarioIndisponivelException;
import excecoes.LimiteConsultaAtingidoException;
import excecoes.PacienteIndisponivelException;
import servicos.ConsultaServico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medico extends Pessoa{

    private String crm;
    private String especialidade;

    public Medico(String nome,
                  String cpf ,
                  LocalDate dataNascimento,
                  String crm,
                  String especialidade,
                  ArrayList<Consulta> historicoMedico) {

        super(nome, cpf, dataNascimento, historicoMedico);
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void agendarConsulta(LocalDate dataConsulta,
                                LocalTime horarioInicialConsulta,
                                LocalTime duracaoConsulta,
                                Paciente pacienteAssociado,
                                String especialidadeRequerida,
                                double valorConsulta,
                                ConsultaServico registroConsulta) {

        Consulta novaConsulta = new Consulta(dataConsulta, horarioInicialConsulta, duracaoConsulta, Consulta.Status.AGENDADA, pacienteAssociado, this, valorConsulta);

        try {

            if(verificarLimiteConsultas(this)) {

                throw new LimiteConsultaAtingidoException();
            }

            // Nao permitir realizar agenda se medico nao estiver disponivel
            if(validarDisponibilidadeMedico(this, dataConsulta, horarioInicialConsulta, novaConsulta.getHorarioFinalConsulta())){
                throw new HorarioIndisponivelException(novaConsulta, horarioInicialConsulta, duracaoConsulta);
            }

            // Nao permitir realizar agenda se medico nao tiver especialidade requerida
            if (!validarEspecialidadeMedico(novaConsulta, especialidadeRequerida)) {
                throw new EspecialidadeInvalidaException(this);
            }

            // Nao permitir realizar agenda se paciente tiver outra consulta no mesmo dia
            if(validarDisponibilidadePaciente(pacienteAssociado, dataConsulta)){
                throw new PacienteIndisponivelException(pacienteAssociado);
            }

        } catch (LimiteConsultaAtingidoException | HorarioIndisponivelException | PacienteIndisponivelException | EspecialidadeInvalidaException e) {
            System.out.println("Erro ao agendar consulta: " + e.getMessage());
            return;
        }


        System.out.println("Horario Disponivel! Agendando consulta...");
        //registroConsulta.adicionar(novaConsulta);
        pacienteAssociado.adicionarConsulta(novaConsulta);
        this.adicionarConsulta(novaConsulta);
    }

    public void cancelarConsulta(String ID, ConsultaServico registroConsulta) {

        Consulta consulta = registroConsulta.buscar(ID);

        if (consulta == null) {
            System.out.println("Nao existe essa consulta, portanto nao pode ser cancelada!");
            return;
        }

        consulta.setStatus(Consulta.Status.CANCELADA);
        System.out.println("Consulta cancelada!");
    }

    public void prescreverTratamento(Consulta consulta, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {

        consulta.setPrescricao(new Prescricao(consulta, examesPrescritos, medicamentos, dataValidade));
    }

    public void finalizarConsulta(String ID, ConsultaServico registroConsultas, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {

        Consulta consulta = registroConsultas.buscar(ID);

        if (consulta == null) {
            System.out.println("Nao existe essa consulta, portanto nao pode ser finalizada!");
            return;
        }

        if (consulta.getStatus() == Consulta.Status.AGENDADA) {
            consulta.setStatus(Consulta.Status.REALIZADA);
            prescreverTratamento(consulta, examesPrescritos, medicamentos, dataValidade);
            System.out.println("Consulta " + consulta.getId() + " marcada como REALIZADA.");
        } else {
            System.out.println("Apenas consultas AGENDADAS podem ser finalizadas.");
        }

    }

    public boolean verificarLimiteConsultas(Medico medicoResponsavel) {
        int limiteConsultasMedico = 6;
        int consultasAtivas = 0;

        for (Consulta consulta : medicoResponsavel.getHistoricoMedico()) {
            if (consulta.getStatus() != Consulta.Status.CANCELADA) {
                consultasAtivas++;
            }
        }

        return consultasAtivas >= limiteConsultasMedico;
    }

    public boolean validarDisponibilidadeMedico(Medico medicoResponsavel, LocalDate novaData, LocalTime novoInicio, LocalTime novoFim){

        for (Consulta consulta : medicoResponsavel.getHistoricoMedico()){

            if (consulta.getStatus() == Consulta.Status.CANCELADA) continue;

            LocalDate dataAgendada = consulta.getDataConsulta();
            LocalTime inicioAgendado = consulta.getHorarioInicialConsulta();
            LocalTime fimAgendado = consulta.getHorarioFinalConsulta();

            boolean diasIguais = (dataAgendada.equals(novaData));
            boolean conflitoHorarios = (novoInicio.isBefore(fimAgendado) && novoFim.isAfter(inicioAgendado));
            boolean conflitoAgenda = diasIguais && conflitoHorarios;

            if(conflitoAgenda) return true;
        }
        return false;
    }

    private boolean validarDisponibilidadePaciente(Paciente pacienteAssociado, LocalDate dataConsulta){

        ArrayList<Consulta> consultasPaciente = pacienteAssociado.getHistoricoMedico();
        for (Consulta consulta : consultasPaciente){

            if (consulta.getStatus() == Consulta.Status.CANCELADA) continue;
            if (pacienteAssociado.getCpf().equals(consulta.getPacienteAssociado().getCpf()) && consulta.getDataConsulta().equals(dataConsulta)) return true; // Paciente ja tem uma consulta esse dia
        }
        return false; // Paciente nao tem consulta esse dia
    }

    private boolean validarEspecialidadeMedico(Consulta consulta, String especialidadeRequerida){

        String especialidadeMedico = consulta.getMedicoResponsavel().getEspecialidade();
        boolean especialidadeCompativel = especialidadeMedico.equals(especialidadeRequerida);

        return especialidadeCompativel;
    }

}

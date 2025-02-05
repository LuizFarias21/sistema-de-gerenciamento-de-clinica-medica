package servicos;

import entidades.*;
import excecoes.EspecialidadeInvalidaException;
import excecoes.HorarioIndisponivelException;
import excecoes.LimiteConsultaAtingidoException;
import excecoes.PacienteIndisponivelException;
import repositorios.ConsultaRepositorio;
import repositorios.PessoaRepositorio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ConsultaServico {

    public void agendarConsulta(LocalDate dataRealizacao,
                                LocalTime horarioInicialConsulta,
                                LocalTime duracaoConsulta,
                                Paciente pacienteAssociado,
                                Medico medicoResponsavel,
                                String especialidadeRequerida,
                                ConsultaRepositorio consultaRepositorio,
                                PessoaServico pessoaServico,
                                double valor) {

        Consulta novaConsulta = new Consulta(dataRealizacao, horarioInicialConsulta, duracaoConsulta, Consulta.Status.AGENDADA, pacienteAssociado, medicoResponsavel, valor);

        try {

            if(validarLimiteConsultas(medicoResponsavel)) {

                throw new LimiteConsultaAtingidoException();
            }

            // Nao permitir realizar agenda se medico nao estiver disponivel
            if(validarDisponibilidadeMedico(medicoResponsavel, dataRealizacao, horarioInicialConsulta, novaConsulta.getHorarioFinalConsulta())){
                throw new HorarioIndisponivelException(novaConsulta, horarioInicialConsulta, duracaoConsulta);
            }

            // Nao permitir realizar agenda se medico nao tiver especialidade requerida
            if (!validarEspecialidadeMedico(novaConsulta, especialidadeRequerida)) {
                throw new EspecialidadeInvalidaException(medicoResponsavel);
            }

            // Nao permitir realizar agenda se paciente tiver outra consulta no mesmo dia
            if(validarDisponibilidadePaciente(pacienteAssociado, dataRealizacao)){
                throw new PacienteIndisponivelException(pacienteAssociado);
            }

        } catch (LimiteConsultaAtingidoException | HorarioIndisponivelException | PacienteIndisponivelException | EspecialidadeInvalidaException e) {
            System.out.println("Erro ao agendar consulta: " + e.getMessage());
            return;
        }


        System.out.println("Horario disponivel! Agendando consulta...");

        consultaRepositorio.salvar(novaConsulta);
        pessoaServico.adicionarConsulta(novaConsulta, pacienteAssociado);
        pessoaServico.adicionarConsulta(novaConsulta, medicoResponsavel);
    }

    public void cancelarConsulta(Consulta consulta) {

        if (consulta == null) {
            System.out.println("Nao existe essa consulta, portanto nao pode ser cancelada!");
            return;
        }

        consulta.setStatus(Consulta.Status.CANCELADA);
        System.out.println("Consulta cancelada!");
    }

    public void prescreverTratamento(Consulta consulta, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {

        //consulta.setPrescricao(new Prescricao(consulta, examesPrescritos, medicamentos, dataValidade));
    }

//    public void finalizarConsulta(String identificador, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {
//
//        for (Consulta consulta : ) {
//
//        }
//
//        if (consulta == null) {
//            System.out.println("Nao existe essa consulta, portanto nao pode ser finalizada!");
//            return;
//        }
//
//        if (consulta.getStatus() == Consulta.Status.AGENDADA) {
//            consulta.setStatus(Consulta.Status.REALIZADA);
//            prescreverTratamento(consulta, examesPrescritos, medicamentos, dataValidade);
//            System.out.println("Consulta " + consulta.getId() + " marcada como REALIZADA.");
//        } else {
//            System.out.println("Apenas consultas AGENDADAS podem ser finalizadas.");
//        }
//    }
    
    public boolean validarLimiteConsultas(Medico medicoResponsavel) {
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

            LocalDate dataAgendada = consulta.getDataRealizacao();
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

        ArrayList<Consulta> historicoMedicoPaciente = pacienteAssociado.getHistoricoMedico();
        for (Consulta consulta : historicoMedicoPaciente){

            if (consulta.getStatus() == Consulta.Status.CANCELADA) continue;
            if (pacienteAssociado.getCpf().equals(consulta.getPacienteAssociado().getCpf()) && consulta.getDataRealizacao().equals(dataConsulta)) return true; // Paciente ja tem uma consulta esse dia
        }
        return false; // Paciente nao tem consulta esse dia
    }

    private boolean validarEspecialidadeMedico(Consulta consulta, String especialidadeRequerida){

        String especialidadeMedico = consulta.getMedicoResponsavel().getEspecialidade();
        boolean especialidadeCompativel = especialidadeMedico.equals(especialidadeRequerida);

        return especialidadeCompativel;
    }
}

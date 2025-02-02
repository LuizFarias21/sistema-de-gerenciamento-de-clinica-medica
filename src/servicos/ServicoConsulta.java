package servicos;

import entidades.*;
import excecoes.EspecialidadeInvalidaException;
import excecoes.HorarioIndisponivelException;
import excecoes.PacienteIndisponivelException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ServicoConsulta extends ServicosCRUD<Consulta> {

    @Override
    public void adicionar(Consulta consulta) {
        if(buscar(consulta.getID()) == null){
            lista.add(consulta);
            System.out.println("Consulta[" + consulta.getID() + "] adicionada com sucesso!");
        } else {
            System.out.println("Ja existe essa consulta!");
        }
    }

    @Override
    public Consulta buscar(String ID) {
        for (Consulta consulta : lista) {
            if (consulta.getID().equals(ID)){
                return consulta;
            }
        }
        return null;
    }

    @Override
    public void atualizar(String ID, Consulta consulta) {
        consulta = buscar(ID);
        if (consulta != null) {
            System.out.println("Consulta atualizada com sucesso");

        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    @Override
    public void remover(String ID) {
        Consulta consulta = buscar(ID);
        if(consulta != null){
            lista.remove(consulta);
            System.out.println("Consulta removida com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    public void agendarConsulta(LocalDate dataConsulta,
                                LocalTime horarioInicialConsulta,
                                LocalTime duracaoConsulta,
                                Paciente pacienteAssociado,
                                Medico medicoResponsavel,
                                String especialidadeRequerida,
                                double valorConsulta) {

        Consulta novaConsulta = new Consulta(dataConsulta, horarioInicialConsulta, duracaoConsulta, Consulta.Status.AGENDADA, pacienteAssociado, medicoResponsavel, new ArrayList<Exame>(), new ArrayList<Medicamento>(), valorConsulta);

        try {

            // Nao permitir realizar agenda se medico nao estiver disponivel
            if(validarDisponibilidadeMedico(medicoResponsavel, dataConsulta, horarioInicialConsulta, novaConsulta.getHorarioFinalConsulta())){
                throw new HorarioIndisponivelException(novaConsulta, horarioInicialConsulta, duracaoConsulta);
            }

            // Nao permitir realizar agenda se paciente tiver outra consulta no mesmo dia
            if(validarDisponibilidadePaciente(pacienteAssociado, dataConsulta)){
                throw new PacienteIndisponivelException(pacienteAssociado);
            }

            // Nao permitir realizar agenda se medico nao tiver especialidade requerida
            if (!validarEspecialidadeMedico(novaConsulta, especialidadeRequerida)) {
                throw new EspecialidadeInvalidaException(medicoResponsavel);
            }

        } catch (HorarioIndisponivelException | PacienteIndisponivelException | EspecialidadeInvalidaException e) {
            System.out.println("Erro ao agendar consulta: " + e.getMessage());
            return;
        }


        System.out.println("Horario disponivel! Agendando consulta...");
        adicionar(novaConsulta);
        pacienteAssociado.adicionarConsulta(novaConsulta);
        medicoResponsavel.adicionarConsulta(novaConsulta);
    }

    public void cancelarConsulta(String ID) {

        Consulta consulta = buscar(ID);

        if (consulta == null) {
            System.out.println("Nao existe essa consulta, portanto nao pode ser cancelada!");
            return;
        }

        consulta.setStatus(Consulta.Status.CANCELADA);
        System.out.println("Consulta cancelada!");
    }

    public void finalizarConsulta(String ID) {
        Consulta consulta = buscar(ID);

        if (consulta == null) {
            System.out.println("Nao existe essa consulta, portanto nao pode ser finalizada!");
            return;
        }

        if (consulta.getStatus() == Consulta.Status.AGENDADA) {
            consulta.setStatus(Consulta.Status.REALIZADA);
            System.out.println("Consulta " + consulta.getID() + " marcada como REALIZADA.");
        } else {
            System.out.println("Apenas consultas AGENDADAS podem ser finalizadas.");
        }

    }

    public boolean validarDisponibilidadeMedico(Medico medicoResponsavel, LocalDate novaData, LocalTime novoInicio, LocalTime novoFim){

        for (Consulta consulta : medicoResponsavel.getHistoricoConsultas()){

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

        ArrayList<Consulta> consultasPaciente = pacienteAssociado.getHistoricoConsultas();
        for (Consulta consulta : consultasPaciente){

            if (consulta.getStatus() == Consulta.Status.CANCELADA) continue;

            if (consulta.getDataConsulta().equals(dataConsulta)) return true; // Paciente ja tem uma consulta esse dia
        }
        return false; // Paciente nao tem consulta esse dia
    }

    private boolean validarEspecialidadeMedico(Consulta consulta, String especialidadeRequerida){

        String especialidadeMedico = consulta.getMedicoResponsavel().getEspecialidade();
        boolean especialidadeCompativel = especialidadeMedico.equals(especialidadeRequerida);

        return especialidadeCompativel;
    }
}

package servicos;

import entidades.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ServicoConsulta extends ServicosCRUD<Consulta>{

    @Override
    public void adicionar(Consulta consulta) {
        if(buscar(consulta.getID()) == null){
            lista.add(consulta);
            System.out.println("Consulta adicionada com sucesso!");
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
    public void atualizar(String ID, Consulta novaConsulta) {
        Consulta consulta = buscar(ID);
        if (consulta != null)
        {
            System.out.println("Paciente atualizado com sucesso");
        }
        else System.out.println("Paciente não encontrado.");
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

    public Consulta realizarConsulta(LocalTime duracaoConsulta, Paciente pacienteAssociado, Medico medicoAssociado, double valorConsulta) {
        return new Consulta(LocalDate.now(), LocalTime.now(), duracaoConsulta, 0, pacienteAssociado, medicoAssociado, new ArrayList<Exame>(), new ArrayList<Medicamento>(), valorConsulta);
    }

    public Consulta agendarConsulta(LocalDate dataConsulta, LocalTime horarioConsulta, LocalTime duracaoConsulta, Paciente pacienteAssociado, Medico medicoAssociado, double valorConsulta){

        for (Consulta consulta : medicoAssociado.getHistoricoMedico()){
            boolean diaCompativel = consulta.getDataConsulta() == dataConsulta;
            boolean intervaloHorario = consulta.getHorarioConsulta().isAfter(horarioConsulta) && consulta.getDuracaoConsulta().isBefore(duracaoConsulta);
            boolean horarioCompativel = consulta.getHorarioConsulta().equals(horarioConsulta) || intervaloHorario;

            if(!(horarioCompativel && diaCompativel)){
                System.out.println("Horario disponivel! Agendando consulta...");
                return new Consulta(dataConsulta, horarioConsulta, duracaoConsulta, 1, pacienteAssociado, medicoAssociado, new ArrayList<Exame>(), new ArrayList<Medicamento>(), valorConsulta);
            }
        }

        return null;
    }

    public void cancelarConsulta(Consulta consulta){
        Paciente pacienteAssociado = consulta.getPacienteAssociado();
        Medico medicoResponsavel = consulta.getMedicoResponsavel();
        pacienteAssociado.getHistoricoMedico().remove(consulta);
        medicoResponsavel.getHistoricoMedico().remove(consulta);

    }

    public boolean disponibilidadeMedico(LocalDate dataConsulta, LocalTime horarioConsulta, LocalTime duracaoConsulta){
        //Paciente paciente = ;
        //Medico medico;

        //if (dataConsulta == medico.getHistoricoMedico().contains())
        return true;
    }

    public boolean disponibilidadePaciente(){
        return true;
    }

    public boolean especialidadeRequerida(){
        return true;
    }
}

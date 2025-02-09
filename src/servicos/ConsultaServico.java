package servicos;

<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
public class ConsultaServico {

}
=======
import java.util.ArrayList;
>>>>>>> Stashed changes
import entidades.*;
import excecoes.DadoInvalidoException;
import repositorios.ConsultaRepositorio;

public class ConsultaServico {

    private ConsultaRepositorio consultaRepositorio;
    private PacienteServico pacienteServico;
    private MedicoServico medicoServico;
<<<<<<< Updated upstream
    private Consulta consultaConflitante;
=======
>>>>>>> Stashed changes

    public ConsultaServico(ConsultaRepositorio consultaRepositorio, PacienteServico pacienteServico, MedicoServico medicoServico) {
        this.consultaRepositorio = consultaRepositorio;
        this.pacienteServico = pacienteServico;
        this.medicoServico = medicoServico;
    }

<<<<<<< Updated upstream
    // Criação de uma nova consulta
    public void criarConsulta(Consulta consulta) throws DadoInvalidoException {

        // Verifica se o paciente e o médico existem pelo CPF
        if (pacienteServico.buscar(consulta.getPacienteAssociado().getCpf()) == null) {
            throw new DadoInvalidoException("Paciente não encontrado.");
        }
        if (medicoServico.buscar(consulta.getMedicoResponsavel().getCpf()) == null) {
            throw new DadoInvalidoException("Médico não encontrado.");
        }

        // Verifica se há conflito de horário
//        if (verificarConflitoDeHorario(consulta)) {
//            throw new IllegalArgumentException("Horário da consulta conflita com outra.");
//        }
=======
    // Criar uma nova consulta
    public void criarConsulta(Consulta consulta) throws DadoInvalidoException {
        // Verifica se o paciente e o médico existem pelo CPF
        if (pacienteServico.buscarPaciente(consulta.getPacienteAssociado().getCpf()) == null) {
            throw new IllegalArgumentException("Paciente não encontrado.");
        }
        if (medicoServico.buscar(consulta.getMedicoResponsavel().getCpf()) == null) {
            throw new IllegalArgumentException("Médico não encontrado.");
        }

        // Verifica se há conflito de horário
        if (verificarConflitoDeHorario(consulta)) {
            throw new IllegalArgumentException("Horário da consulta conflita com outra.");
        }
>>>>>>> Stashed changes

        consultaRepositorio.salvar(consulta);
    }

<<<<<<< Updated upstream
    // Leitura: Buscar consulta por ID
    public Consulta buscarConsulta(String id) throws DadoInvalidoException {
        Consulta consulta = consultaRepositorio.buscar(id);
        if (consulta == null) {
            throw new DadoInvalidoException("Consulta não encontrada.");
=======
    // Buscar consulta por ID
    public Consulta buscarConsulta(String id) {
        Consulta consulta = consultaRepositorio.buscar(id);
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não encontrada.");
>>>>>>> Stashed changes
        }
        return consulta;
    }

<<<<<<< Updated upstream
    // Atualização: Atualizar uma consulta existente
=======
    // Atualizar uma consulta existente
>>>>>>> Stashed changes
    public void atualizarConsulta(String consultaId, Consulta novaConsulta) throws DadoInvalidoException {
        Consulta consultaExistente = consultaRepositorio.buscar(consultaId);

        if (consultaExistente == null) {
<<<<<<< Updated upstream
            throw new DadoInvalidoException("Consulta não encontrada para atualização.");
=======
            throw new IllegalArgumentException("Consulta não encontrada para atualização.");
>>>>>>> Stashed changes
        }

        // Verifica se o novo paciente e médico existem pelo CPF
        if (pacienteServico.buscar(novaConsulta.getPacienteAssociado().getCpf()) == null) {
<<<<<<< Updated upstream
            throw new DadoInvalidoException("Paciente não encontrado.");
        }
        if (medicoServico.buscar(novaConsulta.getMedicoResponsavel().getCpf()) == null) {
            throw new DadoInvalidoException("Médico não encontrado.");
        }

        // Verifica se há conflito de horário
//        if (verificarConflitoDeHorario(novaConsulta)) {
//            throw new IllegalArgumentException("Horário da consulta conflita com outra.");
//        }

        // Remove a consulta antiga e salva a nova
        consultaRepositorio.remover(consultaExistente);
        consultaRepositorio.salvar(novaConsulta);
    }

    // Faltou o método listar aqui!!

    // Exclusão: Remover uma consulta
    public void removerConsulta(String consultaId) throws DadoInvalidoException {
        Consulta consulta = consultaRepositorio.buscar(consultaId);
        if (consulta == null || !consultaRepositorio.remover(consulta)) {
            throw new DadoInvalidoException("Consulta não encontrada para remoção.");
        }
    }

    // Verificação de conflito de horário (exemplo simples)
//    private boolean verificarConflitoDeHorario(Consulta consulta) {
//        for (Consulta c : consultaRepositorio.listar()) {
//            if (c.getMedicoResponsavel().getCpf().equals(consulta.getMedicoResponsavel().getCpf()) && c.getHorario().equals(consulta.getHorario())) {
//                consultaConflitante = c;
//                return true;
//            }
//        }
//        return false;
//    }
}
=======
            throw new IllegalArgumentException("Paciente não encontrado.");
        }
        if (medicoServico.buscar(novaConsulta.getMedicoResponsavel().getCpf()) == null) {
            throw new IllegalArgumentException("Médico não encontrado.");
        }

        // Verifica se há conflito de horário
        if (verificarConflitoDeHorario(novaConsulta)) {
            throw new IllegalArgumentException("Horário da consulta conflita com outra.");
        }

        // Atualiza a consulta diretamente no repositório
        consultaRepositorio.atualizar(consultaId, novaConsulta);
    }

    // Remover uma consulta
    public void removerConsulta(String consultaId) {
        Consulta consulta = consultaRepositorio.buscar(consultaId);
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não encontrada para remoção.");
        }
        consultaRepositorio.remover(consulta);
    }

    // Verificação de conflito de horário
    public boolean verificarConflitoDeHorario(Consulta consulta) {
        for (Consulta c : consultaRepositorio.listar()) {
            if (c.getMedicoResponsavel().getCpf().equals(consulta.getMedicoResponsavel().getCpf()) 
                && c.getHorario().equals(consulta.getHorario()) 
                && c.getDataAgendada().equals(consulta.getDataAgendada())) {
                return true;
            }
        }
        return false;
    }

    // Listar todas as consultas
    public ArrayList<Consulta> listar() {
        return consultaRepositorio.listar();
    }
}
>>>>>>> Stashed changes
>>>>>>> Stashed changes

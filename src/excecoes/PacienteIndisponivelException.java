package excecoes;

import entidades.Paciente;

public class PacienteIndisponivelException extends Exception {
    public PacienteIndisponivelException(Paciente pacienteAssociado) {
        super("O paciente " + pacienteAssociado.getNome() + " ja tem uma consulta nesse dia.");
    }
}

package excecoes;

import entidades.Medico;

public class EspecialidadeInvalidaException extends Exception {
    public EspecialidadeInvalidaException(Medico medicoResponsavel) {
        super("Dr. " +  medicoResponsavel.getNome() + " nao tem a especialidade requerida para esta consulta.");
    }
}

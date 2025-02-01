package excecoes;

import entidades.Medico;

public class EspecialidadeInvalidaException extends Exception {
    public EspecialidadeInvalidaException(Medico medicoResponsavel) {
        super("Dr. " +  medicoResponsavel + " nao tem a especialidade requerida para esta consulta.");
    }
}

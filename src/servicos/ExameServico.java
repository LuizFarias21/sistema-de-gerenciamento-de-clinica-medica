package servicos;

import entidades.Exame;
import entidades.Consulta;
import repositorios.ExameRepositorio;

public class ExameServico extends ClinicaServico<Exame> {

    public ExameServico(ExameRepositorio exameRepositorio) {
        super(exameRepositorio);
    }

    public void associarExameAConsulta(Exame exame, Consulta consulta) {
        consulta.getExamesRealizados().add(exame);
        exame.setConsultaAssociada(consulta);
    }
}

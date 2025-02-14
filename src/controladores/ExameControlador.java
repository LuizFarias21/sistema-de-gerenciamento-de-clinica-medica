package controladores;

import entidades.Exame;
import servicos.ExameServico;
import visoes.ExameVisao;

public class ExameControlador extends TratamentoControlador<Exame> {
    private ExameServico exameServico;
    private ExameVisao exameVisao;

    public ExameControlador(ExameServico exameServico) {
        this.exameServico = exameServico;
    }
}

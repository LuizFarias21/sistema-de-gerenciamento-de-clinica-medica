package controladores;

import entidades.Consulta;
import servicos.ConsultaServico;
import visoes.ConsultaVisao;

public class ConsultaControlador extends TratamentoControlador<Consulta> {

    private ConsultaServico consultaServico;
    private ConsultaVisao consultaVisao;

    public ConsultaControlador(ConsultaServico consultaServico) {
        this.consultaServico = consultaServico;
    }
}

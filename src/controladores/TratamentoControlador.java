package controladores;

import entidades.Consulta;
import entidades.Tratamento;
import excecoes.DadoInvalidoException;
import servicos.TratamentoServico;
import visoes.GenericoVisao;

import java.util.ArrayList;

public abstract class TratamentoControlador<TipoTratamento extends Tratamento> extends GenericoControlador<TipoTratamento> {

    private TratamentoServico<TipoTratamento> tratamentoServico;

    public TratamentoControlador(TratamentoServico<TipoTratamento> tratamentoServico) {
        this.tratamentoServico = tratamentoServico;
    }

    @Override
    public void remover() {
        String id = GenericoVisao.solicitarEntrada("Digite o ID do tratamento que deseja remover:");

        try {
            tratamentoServico.remover(id);
            GenericoVisao.exibirMensagemInfo("Tratamento de ID: " + id + " foi removido com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }
}

package controladores;

import entidades.Exame;
import entidades.Consulta;
import excecoes.DadoInvalidoException;
import servicos.ExameServico;
import visoes.ExameVisao;

import java.time.LocalDate;
import java.util.ArrayList;

public class ExameControlador extends ClinicaControlador<Exame> {
    private ExameServico exameServico;
    private ExameVisao exameInterface;

    public ExameControlador(ExameServico exameServico) {
        this.exameServico = exameServico;
    }

    public void setExameInterface(ExameVisao exameInterface) {
        this.exameInterface = exameInterface;
    }

    public void cadastrarExame(String tipo, LocalDate dataRealizacao, String resultado, Consulta consultaAssociada) {
        Exame exame = new Exame(tipo, dataRealizacao, resultado, consultaAssociada);

        try {
            exameServico.cadastrar(exame); // Cadastrar o exame no serviço
            exameInterface.exibirMensagemInfo("Exame cadastrado com sucesso!");
        } catch (DadoInvalidoException e) {
            exameInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
        }
    }

    public Exame buscarExame(String id) {
        try {
            Exame exame = exameServico.buscar(id); // Buscar exame pelo ID

            if (exame != null) {
                exameInterface.exibirMensagemInfo("Exame encontrado: " + exame.getCusto());
            }

            return exame;
        } catch (DadoInvalidoException e) {
            exameInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
        }
        return null;
    }

    public void listarExames() {
        String mensagem = "";

        try {
            ArrayList<Exame> listaExames = exameServico.listar(); // Lista exames cadastrados

            for (Exame exame : listaExames) {
                mensagem += "ID: " + exame.getId() + " - Tipo: " + exame.getCusto() + "\n"; // Formata a mensagem
            }

            exameInterface.exibirMensagemInfo(mensagem); // Exibe a lista de exames

        } catch (DadoInvalidoException e) {
            exameInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
        }
    }

    public void excluirExame(String id) {
        try {
            exameServico.excluir(id); // Exclui o exame do serviço
            exameInterface.exibirMensagemInfo("Exame com ID " + id + " foi excluído com sucesso!");

        } catch (DadoInvalidoException e) {
            exameInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
        }
    }
}

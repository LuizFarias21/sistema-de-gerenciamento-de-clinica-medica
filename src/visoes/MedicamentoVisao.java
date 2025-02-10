package visoes;

import javax.swing.*;
import controladores.MedicamentoControlador;
import entidades.Medicamento;
import excecoes.DadoInvalidoException;

public class MedicamentoVisao extends GenericoVisao {

    private MedicamentoControlador medicamentoControlador;

    public MedicamentoVisao(MedicamentoControlador medicamentoControlador) {
        this.medicamentoControlador = medicamentoControlador;
    }

    @Override
    public void exibirVisao() throws DadoInvalidoException {
        while (true) {
            String[] opcoes = {"Cadastrar Medicamento", "Buscar Medicamento", "Listar Medicamentos",
                    "Remover Medicamento", "Voltar"};

            int escolha = JOptionPane.showOptionDialog(null, "Menu Medicamentos", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0: // Cadastrar medicamento
                    cadastrarVisao();
                    break;
                case 1: // Buscar medicamento
                    buscarVisao();
                    break;
                case 2: // Listar medicamentos
                    listarVisao();
                    break;
                case 3: // Remover medicamento
                    excluirVisao();
                    break;
                case 4: // Sair
                    return;
            }
        }
    }

    @Override
    public void cadastrarVisao() throws DadoInvalidoException {
        String nome = JOptionPane.showInputDialog("Digite o nome do medicamento:");
        String tipo = JOptionPane.showInputDialog("Digite o tipo do medicamento (ex: comprimido, solução):");
        String dosagem = JOptionPane.showInputDialog("Digite a dosagem do medicamento:");
        String descricao = JOptionPane.showInputDialog("Digite a descrição do medicamento:");

        Medicamento medicamento = new Medicamento(nome);

        medicamentoControlador.cadastrar(medicamento);
    }

    @Override
    public void buscarVisao() throws DadoInvalidoException {
        String nome = JOptionPane.showInputDialog("Digite o nome do medicamento:");
        medicamentoControlador.buscar(nome);
    }

    @Override
    public void listarVisao() throws DadoInvalidoException {
        medicamentoControlador.listar();
    }

    @Override
    public void atualizarVisao() {
        JOptionPane.showMessageDialog(null, "Funcionalidade ainda não implementada.");
    }

    @Override
    public void excluirVisao() throws DadoInvalidoException {
        String nome = JOptionPane.showInputDialog("Digite o nome do medicamento que deseja excluir:");
        medicamentoControlador.excluir(nome);
    }
}

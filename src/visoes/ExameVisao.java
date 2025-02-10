package visoes;

import java.time.LocalDate;
import javax.swing.*;

import controladores.ExameControlador;
import entidades.Consulta;

public class ExameVisao extends GenericoVisao {

    private ExameControlador exameControlador;

    public ExameVisao(ExameControlador exameControlador) {
        this.exameControlador = exameControlador;
    }

    @Override
    public void exibirVisao() {
        while (true) {
            String[] opcoes = {"Cadastrar Exame", "Buscar Exame", "Listar Exames",
                    "Remover Exame", "Voltar"};

            int escolha = JOptionPane.showOptionDialog(null, "Menu Exames", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (escolha) {
                case 0: // Cadastrar exame
                    cadastrarVisao();
                    break;
                case 1: // Buscar exame
                    buscarVisao();
                    break;
                case 2: // Listar exames
                    listarVisao();
                    break;
                case 3: // Remover exame
                    excluirVisao();
                    break;
                case 4: // Sair
                    return;
            }
        }
    }

    @Override
    public void cadastrarVisao() {
        String tipo = JOptionPane.showInputDialog("Digite o tipo do exame:");
        LocalDate dataRealizacao = LocalDate.parse(JOptionPane.showInputDialog("Digite a data do exame (YYYY-MM-DD):"));
        String resultado = JOptionPane.showInputDialog("Digite o resultado do exame:");
        // Para simplificar, o usuário pode digitar um ID de consulta já cadastrada
        int idConsulta = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da consulta associada ao exame:"));

        Consulta consultaAssociada = new Consulta(dataRealizacao, null, null, null, null, null, null, resultado, idConsulta); // Supondo que existe um método para buscar a consulta real pelo ID
        consultaAssociada.setId(idConsulta);

        exameControlador.cadastrarExame(tipo, dataRealizacao, resultado, consultaAssociada);
    }

    @Override
    public void buscarVisao() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do exame:"));
        exameControlador.buscarExame(id);
    }

    @Override
    public void listarVisao() {
        exameControlador.listarExames();
    }

    @Override
    public void atualizarVisao() {
        JOptionPane.showMessageDialog(null, "Funcionalidade ainda não implementada.");
    }

    @Override
    public void excluirVisao() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do exame que deseja excluir:"));
        exameControlador.excluirExame(id);
    }
}

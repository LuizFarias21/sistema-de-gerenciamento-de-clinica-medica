package visoes;

import controladores.ConsultaControlador;
import controladores.ExameControlador;
import entidades.Exame;

import javax.swing.*;

public class ExameVisao extends TratamentoVisao<Exame> {

    private ExameControlador exameControlador;
    private ExameVisao exameVisao;

    public ExameVisao(ExameControlador exameControlador) {
        super(exameControlador);
        this.exameControlador = exameControlador;
    }

    @Override
    public void exibir() {
        while (true) {

            String[] opcoes = {"Cadastrar Exame", "Buscar Exame", "Atualizar Exame", "Remover Exame", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Exame", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0:
                    cadastrar();
                    break;
                case 1:
                    buscar();
                    break;
                case 2:
                    atualizar();
                    break;
                case 3:
                    remover();
                    break;
                case 4:
                    return;
            }
        }
    }
}

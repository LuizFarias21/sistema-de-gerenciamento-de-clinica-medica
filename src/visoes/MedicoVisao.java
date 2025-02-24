package visoes;

import java.time.LocalDate;
import javax.swing.*;

import controladores.MedicoControlador;

public class MedicoVisao extends PessoaVisao {

    private MedicoControlador medicoControlador;

    public MedicoVisao(MedicoControlador medicoControlador) {
        super(medicoControlador);
        this.medicoControlador = medicoControlador;
    }

    @Override
    public void exibir() {
        while (true) {

            String[] opcoes = {"Cadastrar Médicos", "Buscar Médicos",
                    "Atualizar Médicos", "Remover Médicos", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Médico", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

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

    @Override
    public void listar() {

    }
}

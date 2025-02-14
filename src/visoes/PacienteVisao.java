package visoes;

import java.time.LocalDate;
import javax.swing.*;

import controladores.PacienteControlador;

public class PacienteVisao extends PessoaVisao {

    private PacienteControlador pacienteControlador;

    public PacienteVisao(PacienteControlador pacienteControlador) {
        super(pacienteControlador);
        this.pacienteControlador = pacienteControlador;
    }

    @Override
    public void exibir() {
        while (true) {

            String[] opcoes = {"Cadrastar Pacientes", "Buscar Pacientes",
                    "Atualizar Pacientes", "Remover Pacientes", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Paciente", "Escolha uma opção",
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
}


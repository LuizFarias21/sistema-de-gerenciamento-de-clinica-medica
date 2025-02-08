package interfaces;

import javax.swing.*;

public class AtendimentoInterface {

    public void exibirInterface() {
        while(true) {

            String[] options = {"Agendar Consulta", "Finalizar Consulta", "Cancelar Consulta", "Prescrever Tratamento", "Voltar"};

            int escolha = JOptionPane.showOptionDialog(null, "Atendimento", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
            }
        }
    }
}

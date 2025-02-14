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

            String[] opcoes = {"Cadastrar Médicos", "Buscar Médicos", "Listar Médicos",
                    "Atualizar Médicos", "Remover Médicos", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Médico", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0: // cadastrar médico
                    cadastrar();
                    break;
                case 1: // buscar médico
                    buscar();
                    break;
                case 2: // listar médicos
                    listar();
                    break;
                case 3: // atualizar médico
                    atualizar();
                    break;
                case 4: // remover médico
                    remover();
                    break;
                case 5: // sair
                    return;
            }
        }
    }
}

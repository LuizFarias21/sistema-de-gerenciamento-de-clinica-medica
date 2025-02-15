package visoes;

import controladores.ConsultaControlador;
import entidades.Consulta;

import javax.swing.*;

public class ConsultaVisao extends TratamentoVisao<Consulta> {

    private ConsultaControlador consultaControlador;

    public ConsultaVisao(ConsultaControlador consultaControlador) {
        super(consultaControlador);
        this.consultaControlador = consultaControlador;
    }

    @Override
    public void exibir() {
        while (true) {

            String[] opcoes = {"Agendar Consulta", "Cancelar Consulta", "Finalizar Consulta", "Buscar Consulta",
                    "Atualizar Consulta", "Remover Consulta", "Voltar"};

            // Exibe a caixa de texto com a opção selecionada
            int escolha = JOptionPane.showOptionDialog(null, "Menu Consulta", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            // Verificar escolha do usuário
            switch (escolha) {
                case 0:
                    agendar();
                    break;
                case 1:
                    cancelar();
                    break;
                case 2:
                    finalizar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    atualizar();
                    break;
                case 5:
                    remover();
                    break;
                case 6:
                    return;
            }
        }
    }

// Prescrever vai ocorrer dentro de agendar consulta

    public void agendar() {

    }

    public void cancelar() {

    }

    public void finalizar() {

    }
}

package interfaces;

import javax.swing.*;

public class SistemaInterface {

    private final AtendimentoInterface atendimentoInterface;
    private final PacienteInterface pacienteInterface;
    private final MedicoInterface medicoInterface;
    private final ConsultaInterface consultaInterface;
    private final ExameInterface exameInterface;
    private final MedicamentoInterface medicamentoInterface;

    public SistemaInterface(AtendimentoInterface atendimentoInterface, PacienteInterface pacienteInterface, MedicoInterface medicoInterface, ConsultaInterface consultaInterface, ExameInterface exameInterface, MedicamentoInterface medicamentoInterface) {
        this.atendimentoInterface = atendimentoInterface;
        this.pacienteInterface = pacienteInterface;
        this.medicoInterface = medicoInterface;
        this.consultaInterface = consultaInterface;
        this.exameInterface = exameInterface;
        this.medicamentoInterface = medicamentoInterface;
    }

    public void exibirInterface() {
        while(true) {

            String[] options = {"Gerenciar Atendimento", "Gerenciar Pacientes", "Gerenciar Médicos", "Gerenciar Consultas", "Gerenciar Exames", "Gerenciar Medicamentos", "Sair"};

            int escolha = JOptionPane.showOptionDialog(null, "Gerenciador de clínica médica", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    atendimentoInterface.exibirInterface();
                    break;
                case 1:
                    pacienteInterface.exibirInterface();;
                    break;
                case 2:
                    medicoInterface.exibirInterface();
                case 3:
                    consultaInterface.exibirInterface();
                case 4:
                    exameInterface.exibirInterface();
                case 5:
                    medicamentoInterface.exibirInterface();
                case 6:
                    return;
            }
        }
    }
}

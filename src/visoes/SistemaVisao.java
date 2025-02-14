package visoes;

import javax.swing.*;

public class SistemaVisao {

    private final PacienteVisao pacienteInterface;
    private final MedicoVisao medicoInterface;
    private final ConsultaVisao consultaVisao;
    private final ExameVisao exameVisao;
    private final MedicamentoVisao medicamentoInterface;

    public SistemaVisao(PacienteVisao pacienteInterface, MedicoVisao medicoInterface, ConsultaVisao consultaVisao, ExameVisao exameVisao, MedicamentoVisao medicamentoInterface) {
        this.pacienteInterface = pacienteInterface;
        this.medicoInterface = medicoInterface;
        this.consultaVisao = consultaVisao;
        this.exameVisao = exameVisao;
        this.medicamentoInterface = medicamentoInterface;
    }

    public void exibirVisao() {
        while(true) {

            String[] options = {"Gerenciar Pacientes", "Gerenciar Médicos", "Gerenciar Consultas", "Gerenciar Exames", "Gerenciar Medicamentos", "Sair"};

            int escolha = JOptionPane.showOptionDialog(null, "Gerenciador de clínica médica", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    pacienteInterface.exibirVisao();
                    break;
                case 1:
                    medicoInterface.exibirVisao();
                    break;
                case 2:
                    consultaVisao.exibirVisao();
                    break;
                case 3:
                    exameVisao.exibirVisao();
                    break;
                case 4:
                    medicamentoInterface.exibirVisao();
                case 5:
                    return;
            }
        }
    }
}

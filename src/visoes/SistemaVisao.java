package visoes;

import javax.swing.*;

public class SistemaVisao {

    private final PacienteVisao pacienteVisao;
    private final MedicoVisao medicoInterface;
    private final ConsultaVisao consultaVisao;
    private final ExameVisao exameVisao;
    private final MedicamentoVisao medicamentoVisao;

    public SistemaVisao(PacienteVisao pacienteVisao, MedicoVisao medicoInterface, ConsultaVisao consultaVisao, ExameVisao exameVisao, MedicamentoVisao medicamentoVisao) {
        this.pacienteVisao = pacienteVisao;
        this.medicoInterface = medicoInterface;
        this.consultaVisao = consultaVisao;
        this.exameVisao = exameVisao;
        this.medicamentoVisao = medicamentoVisao;
    }

    public void exibirVisao() {
        while(true) {

            String[] options = {"Gerenciar Pacientes", "Gerenciar Médicos", "Gerenciar Consultas", "Gerenciar Exames", "Gerenciar Medicamentos", "Sair"};

            int escolha = JOptionPane.showOptionDialog(null, "Gerenciador de clínica médica", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    pacienteVisao.exibir();
                    break;
                case 1:
                    medicoInterface.exibir();
                    break;
                case 2:
                    consultaVisao.exibir();
                    break;
                case 3:
                    exameVisao.exibir();
                    break;
                case 4:
                    medicamentoVisao.exibir();
                    break;
                case 5:
                    return;
            }
        }
    }
}

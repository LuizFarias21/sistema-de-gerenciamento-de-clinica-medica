package interfaces;

import javax.swing.*;

public class PrincipalInterface {

    private final PacienteInterface pacienteInterface;
    private final MedicoInterface medicoInterface;
    private final ConsultaInterface consultaInterface;

    public PrincipalInterface(PacienteInterface pacienteInterface, MedicoInterface medicoInterface, ConsultaInterface consultaInterface) {
        this.pacienteInterface = pacienteInterface;
        this.medicoInterface = medicoInterface;
        this.consultaInterface = consultaInterface;
    }

    public void exibirInterfacePrincipal() {

        while(true) {

            String[] options = {"Gerenciar Pacientes", "Gerenciar Médicos", "Gerenciar Consultas", "Sair"};

            int escolha = JOptionPane.showOptionDialog(null, "Gerenciador de clínica médica", "Escolha uma opção",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (escolha) {
                case 0:
                    pacienteInterface.exibirInterface();
                    break;
                case 1:
                    //medicoInterface.abrirInterfaceMedico();
                    break;
                case 2:
                    //consultaInterface.abrirInterfaceConsulta();
                    break;
                case 3:
                    return;
            }
        }
    }

}

package aplicacao;

import controladores.MedicoControlador;
import controladores.PacienteControlador;
import interfaces.*;
import repositorios.MedicoRepositorio;
import repositorios.PacienteRepositorio;
import servicos.MedicoServico;
import servicos.PacienteServico;

public class Sistema {
    private SistemaInterface sistemaInterface;

    public Sistema() {
        gerenciarDependencias();
    }

    public void iniciar() {
        sistemaInterface.exibirInterface();
    }

    public void gerenciarDependencias() {

        AtendimentoInterface atendimentoInterface = new AtendimentoInterface();
        PacienteRepositorio pacienteRepositorio = new PacienteRepositorio();
        PacienteServico pacienteServico = new PacienteServico(pacienteRepositorio);
        PacienteControlador pacienteControlador = new PacienteControlador(pacienteServico);
        PacienteInterface pacienteInterface = new PacienteInterface(pacienteControlador);
        ExameInterface exameInterface = new ExameInterface();
        MedicamentoInterface medicamentoInterface = new MedicamentoInterface();

        pacienteControlador.setPacienteInterface(pacienteInterface);

        MedicoRepositorio medicoRepositorio = new MedicoRepositorio();
        MedicoServico medicoServico = new MedicoServico(medicoRepositorio);
        MedicoControlador medicoControlador = new MedicoControlador(medicoServico);
        MedicoInterface medicoInterface = new MedicoInterface(medicoControlador);
        
        medicoControlador.setMedicoInterface(medicoInterface);
//
//        ConsultaRepositorio consultaRepositorio = new ConsultaRepositorio();
//        ConsultaServico consultaServico = new ConsultaServico(consultaRepositorio, pacienteServico, medicoServico);
//        ConsultaControlador consultaControlador = new ConsultaControlador(consultaServico);

        // Teste!
        //MedicoInterface medicoInterface = null;
        ConsultaInterface consultaInterface = null;

        sistemaInterface = new SistemaInterface(atendimentoInterface, pacienteInterface, medicoInterface, consultaInterface, exameInterface, medicamentoInterface);
    }
}

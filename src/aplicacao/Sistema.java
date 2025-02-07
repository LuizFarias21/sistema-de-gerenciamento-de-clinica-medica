package aplicacao;

import controladores.ConsultaControlador;
import controladores.MedicoControlador;
import controladores.PacienteControlador;
import interfaces.ConsultaInterface;
import interfaces.MedicoInterface;
import interfaces.PrincipalInterface;
import interfaces.PacienteInterface;
import repositorios.ConsultaRepositorio;
import repositorios.MedicoRepositorio;
import repositorios.PacienteRepositorio;
import servicos.ConsultaServico;
import servicos.MedicoServico;
import servicos.PacienteServico;

public class Sistema {
    private PrincipalInterface principalInterface;

    public Sistema() {
        gerenciarDependencias();
    }

    public void iniciar() {
        principalInterface.exibirInterfacePrincipal();
    }

    public void gerenciarDependencias() {

        PacienteRepositorio pacienteRepositorio = new PacienteRepositorio();
        PacienteServico pacienteServico = new PacienteServico(pacienteRepositorio);
        PacienteControlador pacienteControlador = new PacienteControlador(pacienteServico);
        PacienteInterface pacienteInterface = new PacienteInterface(pacienteControlador);

        pacienteControlador.setPacienteInterface(pacienteInterface);

//        MedicoRepositorio medicoRepositorio = new MedicoRepositorio();
//        MedicoServico medicoServico = new MedicoServico(medicoRepositorio);
//        MedicoControlador medicoControlador = new MedicoControlador(medicoServico);
//        MedicoInterface medicoInterface = new MedicoInterface(medicoControlador);
//
//        ConsultaRepositorio consultaRepositorio = new ConsultaRepositorio();
//        ConsultaServico consultaServico = new ConsultaServico(consultaRepositorio, pacienteServico, medicoServico);
//        ConsultaControlador consultaControlador = new ConsultaControlador(consultaServico);

        // Teste!
        MedicoInterface medicoInterface = null;
        ConsultaInterface consultaInterface = null;

        principalInterface = new PrincipalInterface(pacienteInterface, medicoInterface, consultaInterface);
    }
}

package aplicacao;

import controladores.MedicoControlador;
import controladores.PacienteControlador;
import visoes.*;
import repositorios.MedicoRepositorio;
import repositorios.PacienteRepositorio;
import servicos.MedicoServico;
import servicos.PacienteServico;

public class Sistema {
    private SistemaVisao sistemaVisao;

    public Sistema() {
        gerenciarDependencias();
    }

    public void iniciar() {
        sistemaVisao.exibirVisao();
    }

    public void gerenciarDependencias() {

        PacienteRepositorio pacienteRepositorio = new PacienteRepositorio();
        PacienteServico pacienteServico = new PacienteServico(pacienteRepositorio);
        PacienteControlador pacienteControlador = new PacienteControlador(pacienteServico);
        PacienteVisao pacienteVisao = new PacienteVisao(pacienteControlador);
        pacienteControlador.setPacienteVisao(pacienteVisao);
        ExameVisao exameVisao = new ExameVisao();
        MedicamentoVisao medicamentoInterface = new MedicamentoVisao();


        MedicoRepositorio medicoRepositorio = new MedicoRepositorio();
        MedicoServico medicoServico = new MedicoServico(medicoRepositorio);
        MedicoControlador medicoControlador = new MedicoControlador(medicoServico);
        MedicoVisao medicoInterface = new MedicoVisao(medicoControlador);
        medicoControlador.setMedicoVisao(medicoInterface);

        ConsultaVisao consultaVisao = new ConsultaVisao();
//        ConsultaRepositorio consultaRepositorio = new ConsultaRepositorio();
//        ConsultaServico consultaServico = new ConsultaServico(consultaRepositorio);
//        ConsultaControlador consultaControlador = new ConsultaControlador(consultaServico);
//        consultaControlador.serConsultaInterface = new ConsultaInterface(consultaControlador);



        sistemaVisao = new SistemaVisao(pacienteVisao, medicoInterface, consultaVisao, exameVisao, medicamentoInterface);
    }
}

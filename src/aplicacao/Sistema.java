package aplicacao;

import controladores.*;
import repositorios.*;
import servicos.*;
import visoes.*;

public class Sistema {
    private SistemaVisao sistemaVisao;

    public Sistema() {
        gerenciarDependencias();
    }

    public void iniciar() {
        sistemaVisao.exibirVisao();
    }

    public void gerenciarDependencias() {
        sistemaVisao = new SistemaVisao(
                inicializarPacienteVisao(),
                inicializarMedicoVisao(),
                inicializarConsultaVisao(),
                inicializarExameVisao(),
                inicializarMedicamentoVisao());
    }

    private PacienteVisao inicializarPacienteVisao() {
        PacienteRepositorio pacienteRepositorio = new PacienteRepositorio();
        PacienteServico pacienteServico = new PacienteServico(pacienteRepositorio);
        PacienteControlador pacienteControlador = new PacienteControlador(pacienteServico);
        PacienteVisao pacienteVisao = new PacienteVisao(pacienteControlador);
        pacienteControlador.setPacienteVisao(pacienteVisao);

        return pacienteVisao;
    }

    private MedicoVisao inicializarMedicoVisao() {
        MedicoRepositorio medicoRepositorio = new MedicoRepositorio();
        MedicoServico medicoServico = new MedicoServico(medicoRepositorio);
        MedicoControlador medicoControlador = new MedicoControlador(medicoServico);
        MedicoVisao medicoVisao = new MedicoVisao(medicoControlador);
        medicoControlador.setMedicoVisao(medicoVisao);

        return medicoVisao;
    }

    private ConsultaVisao inicializarConsultaVisao() {
        ConsultaRepositorio consultaRepositorio = new ConsultaRepositorio();
        ConsultaServico consultaServico = new ConsultaServico(consultaRepositorio);
        ConsultaControlador consultaControlador = new ConsultaControlador(consultaServico);
        ConsultaVisao consultaVisao = new ConsultaVisao(consultaControlador);
        consultaControlador.setConsultaVisao(consultaVisao);

        return consultaVisao;
    }

    private ExameVisao inicializarExameVisao() {
        ExameRepositorio exameRepositorio = new ExameRepositorio();
        ExameServico exameServico = new ExameServico(exameRepositorio);
        ExameControlador exameControlador = new ExameControlador(exameServico);
        ExameVisao exameVisao = new ExameVisao(exameControlador);
        exameControlador.setExameVisao(exameVisao);

        return exameVisao;
    }

    private MedicamentoVisao inicializarMedicamentoVisao() {
        MedicamentoRepositorio medicamentoRepositorio = new MedicamentoRepositorio();
        MedicamentoServico medicamentoServico = new MedicamentoServico(medicamentoRepositorio);
        MedicamentoControlador medicamentoControlador = new MedicamentoControlador(medicamentoServico);
        MedicamentoVisao medicamentoVisao = new MedicamentoVisao(medicamentoControlador);
        medicamentoControlador.setMedicamentoVisao(medicamentoVisao);

        return medicamentoVisao;
    }

}

//package aplicacao;
//
//import controladores.ConsultaControlador;
//import controladores.MedicoControlador;
//import controladores.PacienteControlador;
//import repositorios.*;
//import servicos.ConsultaServico;
//import servicos.MedicoServico;
//import servicos.PacienteServico;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//public class Principal {
//    public static void main(String[] args) {
//
//        PacienteRepositorio pacienteRepositorio = new PacienteRepositorio();
//        PacienteServico pacienteServico = new PacienteServico(pacienteRepositorio);
//        PacienteControlador pacienteControlador = new PacienteControlador(pacienteServico);
//
//        MedicoRepositorio medicoRepositorio = new MedicoRepositorio();
//        MedicoServico medicoServico = new MedicoServico(medicoRepositorio);
//        MedicoControlador medicoControlador = new MedicoControlador(medicoServico);
//
//
//        ConsultaRepositorio consultaRepositorio = new ConsultaRepositorio();
//        ConsultaServico consultaServico = new ConsultaServico(consultaRepositorio, pacienteServico, medicoServico);
//        ConsultaControlador consultaControlador = new ConsultaControlador(consultaServico);
//
//        pacienteControlador.cadastrarPaciente("Luiz", "1111", LocalDate.now());
//        pacienteControlador.cadastrarPaciente("João", "2222", LocalDate.now());
//        medicoControlador.cadastrarMedico("Maria", "2222", LocalDate.now(), "1234", "Odontologia");
//
//        consultaControlador.agendarConsulta(LocalDate.of(2025, 2, 7),LocalTime.of(10, 0), LocalTime.of(0, 30), pacienteRepositorio.buscar("1111"), medicoRepositorio.buscar("2222"), null, "Odontologia", 100);
//        consultaControlador.agendarConsulta(LocalDate.of(2025, 2, 7), LocalTime.of(12, 0), LocalTime.of(0, 30), pacienteRepositorio.buscar("2222"), medicoRepositorio.buscar("2222"), null, "Odontologia", 100);
//
//        System.out.println("Ok!");
//    }
//}

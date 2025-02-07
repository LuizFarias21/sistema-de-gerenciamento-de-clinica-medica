//package app;
//
//import menu.MenuPrincipal;
//import servicos.ServicoMedico;
//import servicos.ServicoPaciente;
//import servicos.ServicoExame;
//
//public class SistemaClinica {
//    public static void main(String[] args) {
//        // Inicializando serviÃ§os de cada entidade
//        ServicoMedico servicoMedico = new ServicoMedico();
//        ServicoPaciente servicoPaciente = new ServicoPaciente();
//        ServicoExame servicoExame = new ServicoExame();
//
//        // Criando menu principal e executando
//        MenuPrincipal menuPrincipal = new MenuPrincipal(servicoMedico, servicoPaciente, servicoExame);
//        menuPrincipal.exibir();
//    }
//}

//package app;
//
//import entidades.*;
//import servicos.ServicoConsulta;
//import servicos.ServicoExame;
//import servicos.ServicoMedico;
//import servicos.ServicoPaciente;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//
//public class SistemaClinica {
//    public static void main(String[] args) {
//
//        ServicoPaciente registroPacientes = new ServicoPaciente();
//        ServicoMedico registroMedicos = new ServicoMedico();
//
//        ArrayList<Consulta> medicoHistorico1 = new ArrayList<Consulta>();
//        ArrayList<Consulta> pacienteHistorico1 = new ArrayList<Consulta>();
//
//        Paciente paciente1 = new Paciente("Luiz Claudio", "123.456.789-00", LocalDate.of(1969, 7, 14), pacienteHistorico1);
//        Paciente paciente2 = new Paciente("paulo", "111", LocalDate.of(1969, 7, 14), pacienteHistorico1);
//        Paciente paciente3 = new Paciente("carlos", "222", LocalDate.of(1969, 7, 14), pacienteHistorico1);
//        Paciente paciente4 = new Paciente("carlos", "333", LocalDate.of(1969, 7, 14), pacienteHistorico1);
//        registroPacientes.adicionar(paciente1);
//        registroPacientes.adicionar(paciente2);
//        registroPacientes.adicionar(paciente3);
//        registroPacientes.adicionar(paciente4);
//        Medico medico1 = new Medico("Pedro", "987.654.321-00", LocalDate.of(1980, 2, 20), "1234", "Odontologia", medicoHistorico1);
//        registroMedicos.adicionar(medico1);
//
//        ServicoConsulta registroConsultas = new ServicoConsulta();
//
//        medico1.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(12, 0), LocalTime.of(0, 30), registroPacientes.buscar("123.456.789-00"), "Odontologia", 300.00, registroConsultas);
//        medico1.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(15, 0), LocalTime.of(0, 30), registroPacientes.buscar("123.456.789-00"), "Odontologia", 300.00, registroConsultas);
//        medico1.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(15, 0), LocalTime.of(0, 30), registroPacientes.buscar("111"), "Odontologia", 300.00, registroConsultas);
//        medico1.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(10, 0), LocalTime.of(0, 30), registroPacientes.buscar("222"), "Odontologia", 300.00, registroConsultas);
//        medico1.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(9, 0), LocalTime.of(1, 10), registroPacientes.buscar("333"), "Odontologia", 300.00, registroConsultas);
//
//
//        //medico1.cancelarConsulta("1", registroConsultas);
//        //System.out.println(registroConsultas.buscar("1").getStatus());
//
////        System.out.println("================ REGISTRO DE PACIENTES ================\n");
////
////        // Criar registro de pacientes
////        ServicoPaciente registroPacientes = new ServicoPaciente();
////
////        // Cadastrar pacientes
////        registroPacientes.adicionar(new Paciente("Luiz Claudio", "123.456.789-00", LocalDate.of(1969, 7, 14),new ArrayList<Consulta>(), new ArrayList<Exame>()));
////        registroPacientes.adicionar(new Paciente("Luis Carlos", "123.456.789-00", LocalDate.of(1969, 7, 14), new ArrayList<Consulta>(), new ArrayList<Exame>()));
////        registroPacientes.adicionar(new Paciente("Maria", "753.436.912-21", LocalDate.of(2000, 10, 23), new ArrayList<Consulta>(), new ArrayList<Exame>()));
////        registroPacientes.adicionar(new Paciente("Lucas", "111.222.333-44", LocalDate.of(2030, 3, 23), new ArrayList<Consulta>(), new ArrayList<Exame>()));
////        registroPacientes.adicionar(new Paciente("Isabela", "777.777.777-77", LocalDate.of(2002, 2, 15), new ArrayList<Consulta>(), new ArrayList<Exame>()));
////
////
////        // Atualizar registro do paciente
////        registroPacientes.atualizar("753.436.912-21", new Paciente("Maria", "753.436.912-21", LocalDate.of(1970, 7, 14), new ArrayList<Consulta>(), new ArrayList<Exame>()));
////
////        // Excluir paciente do registro de pacientes
////        registroPacientes.remover("111.222.333-44");
////
////        // Buscar paciente
////        System.out.println("Paciente buscado: " + registroPacientes.buscar("123.456.789-00").getNome());
////
////        System.out.println("\n================ REGISTRO DE MEDICOS ================\n");
////
////        // Criar registro de medicos
////        ServicoMedico registroMedicos = new ServicoMedico();
////
////        // Cadastrar medico e atualizar
////        registroMedicos.adicionar(new Medico("Pedro", "987.654.321-00", LocalDate.of(1980, 2, 20), "1234", "Odontologia", new ArrayList<Consulta>(), new ArrayList<Exame>()));
////        registroMedicos.atualizar("987.654.321-00", new Medico("Pedro", "987.654.321-00", LocalDate.of(1980, 2, 20), "1234", "Cardiologia", new ArrayList<Consulta>(), new ArrayList<Exame>()));
////
////        System.out.println("\n================ REGISTRO DE CONSULTAS ================\n");
////
////        // Criar registro de consultas e exames
////        ServicoConsulta registroConsultas = new ServicoConsulta();
////
////        // Realizar consulta e adicionar essa consulta ao historico do paciente e do medico
////        registroConsultas.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(12, 0), LocalTime.of(0, 30), registroPacientes.buscar("123.456.789-00"), registroMedicos.buscar("987.654.321-00"), "Cardiologia", 300.00);
////        registroConsultas.cancelarConsulta("1");
////        registroConsultas.cancelarConsulta("10");
////        registroConsultas.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(10, 00), LocalTime.of(2, 10), registroPacientes.buscar("753.436.912-21"), registroMedicos.buscar("987.654.321-00"), "Cardiologia", 300.00);
////
////
////        registroConsultas.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(16, 0), LocalTime.of(0, 30), registroPacientes.buscar("753.436.912-21"), registroMedicos.buscar("987.654.321-00"), "Cardiologia", 300.00);
////
////        System.out.println(registroPacientes.buscar("123.456.789-00").getHistoricoConsultas());
////        System.out.println(registroMedicos.buscar("987.654.321-00").getHistoricoConsultas());
////        System.out.println("A primeira consulta agendada foi " + registroConsultas.buscar("1").getStatus());
////
////        registroConsultas.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(12, 0), LocalTime.of(0, 30), registroPacientes.buscar("753.436.912-21"), registroMedicos.buscar("987.654.321-00"), "Cardiologia", 300.00);
////
////
////        System.out.println(registroPacientes.buscar("753.436.912-21").getHistoricoConsultas());
////
////
////        System.out.println("\n---- TESTE DE QTDS DE CONSULTA ATINGIDA ----\n");
////
////        System.out.println("Quantidade de consultas atendidas pelo Dr " + registroMedicos.buscar("987.654.321-00").getNome() + ": " + registroMedicos.buscar("987.654.321-00").getHistoricoConsultas().size());
////        registroConsultas.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(16, 0), LocalTime.of(0, 30), registroPacientes.buscar("777.777.777-77"), registroMedicos.buscar("987.654.321-00"), "Cardiologia", 300.00);
////        registroConsultas.agendarConsulta(LocalDate.of(2024, 2, 1), LocalTime.of(17, 0), LocalTime.of(0, 30), registroPacientes.buscar("123.456.789-00"), registroMedicos.buscar("987.654.321-00"), "Cardiologia", 300.00);
//    }
//}

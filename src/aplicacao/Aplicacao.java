package aplicacao;

import entidades.Consulta;
import entidades.Medico;
import entidades.Paciente;
import excecoes.CadastroBloqueadoException;
import servicos.ConsultaServico;
import servicos.MedicoServico;
import servicos.PacienteServico;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Aplicacao {
    public static void main(String[] args) throws CadastroBloqueadoException {

        PacienteServico registroPacientes = new PacienteServico();
        Paciente paciente1 = new Paciente("Luiz Claudio", "123.456.789-00", LocalDate.of(1969, 7, 14), new ArrayList<Consulta>());
        Paciente paciente2 = new Paciente("Luiz ghjghj", "123.456.789-00", LocalDate.of(1969, 7, 14), new ArrayList<Consulta>());


        registroPacientes.salvar(paciente1);
        registroPacientes.salvar(paciente2);
        registroPacientes.atualizar(paciente1, paciente2);
        System.out.println(registroPacientes.buscar("123.456.789-00").getNome());

        ConsultaServico consultaServico = new ConsultaServico();

        MedicoServico registroMedicos = new MedicoServico();
        Medico medico1 = new Medico("Fulano", "123", LocalDate.now(), "1234", "Teste",new ArrayList<Consulta>());
        registroMedicos.atualizar(medico1, new Medico("Fulano", "123", LocalDate.now(), "1111", "Teste",new ArrayList<Consulta>()));
        registroMedicos.salvar(medico1);
        System.out.println(registroMedicos.buscar("123").getCrm());

        medico1.agendarConsulta(LocalDate.now(), LocalTime.now(), LocalTime.now(), paciente1, "errado", 130, consultaServico);
        System.out.println("Teste");
    }
}
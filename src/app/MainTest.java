package app;

import entidades.Consulta;
import entidades.Medico;
import entidades.Paciente;
import entidades.Pessoa;
import excecoes.CadastroBloqueadoException;
import servicos.ServicoConsulta;
import servicos.ServicoMedico;
import servicos.ServicoPaciente;
import servicos.ServicoPessoa;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class MainTest {
    public static void main(String[] args) throws CadastroBloqueadoException {

        ServicoPaciente registroPacientes = new ServicoPaciente();
        Paciente paciente1 = new Paciente("Luiz Claudio", "123.456.789-00", LocalDate.of(1969, 7, 14), new ArrayList<Consulta>());
        Paciente paciente2 = new Paciente("Luiz ghjghj", "123.456.789-00", LocalDate.of(1969, 7, 14), new ArrayList<Consulta>());


        registroPacientes.salvar(paciente1);
        registroPacientes.salvar(paciente2);
        registroPacientes.atualizar(paciente1, paciente2);
        System.out.println(registroPacientes.buscar("123.456.789-00").getNome());

        ServicoConsulta servicoConsulta = new ServicoConsulta();

        ServicoMedico registroMedicos = new ServicoMedico();
        Medico medico1 = new Medico("Fulano", "123", LocalDate.now(), "1234", "Teste",new ArrayList<Consulta>());
        registroMedicos.atualizar(medico1, new Medico("Fulano", "123", LocalDate.now(), "1111", "Teste",new ArrayList<Consulta>()));
        registroMedicos.salvar(medico1);
        System.out.println(registroMedicos.buscar("123").getCrm());

        medico1.agendarConsulta(LocalDate.now(), LocalTime.now(), LocalTime.now(), paciente1, "errado", 130, servicoConsulta);
        System.out.println("Teste");
    }
}
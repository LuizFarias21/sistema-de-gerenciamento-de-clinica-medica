package controladores;

import entidades.Consulta;
import entidades.Paciente;
import excecoes.DadoInvalidoException;
import interfaces.PacienteInterface;
import servicos.PacienteServico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PacienteControlador {

    private PacienteServico pacienteServico;
    private PacienteInterface pacienteInterface;

    public PacienteControlador(PacienteServico pacienteServico) {
        this.pacienteServico = pacienteServico;
    }

    public void setPacienteInterface(PacienteInterface pacienteInterface) {
        this.pacienteInterface = pacienteInterface;
    }

    public void cadastrarPaciente(String nome, String cpf, LocalDate dataNascimento) {
        ArrayList<Consulta> historicoMedico = new ArrayList<Consulta>();
        Paciente paciente = new Paciente(nome, cpf, dataNascimento, historicoMedico);

        try {

            if (validarCpf(cpf) != ResultadoCpf.SUCESSO) {
                throw new DadoInvalidoException("Cadastro bloqueado! Você precisa digitar um CPF válido!");
            }

            pacienteServico.cadastrar(paciente);
        } catch (DadoInvalidoException e ) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
    }

    public Paciente buscarPaciente(String cpf) {

        try {

            if (validarCpf(cpf) != ResultadoCpf.SUCESSO) {
                throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
            }

            Paciente paciente = pacienteServico.buscar(cpf);

            if (paciente != null) {
                pacienteInterface.exibirMensagemInfo("Paciente encontrado: " + paciente.getNome());
            }

            return paciente;
        } catch (DadoInvalidoException e ) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
        return null;
    }

    public void listarPaciente() {

        String mensagem = "";

        try {

            ArrayList<Paciente> listaPacientes = pacienteServico.listar();

            for (Paciente paciente : listaPacientes) {
                mensagem +=  paciente.getCpf() + " - " + paciente.getNome() + "\n";
            }

            pacienteInterface.exibirMensagemInfo(mensagem);

        } catch (DadoInvalidoException e ) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }

    }

    public void atualizarPaciente(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento) {

        try {
            //Paciente novoPaciente = new Paciente(novoNome, novoCpf, novaDataNascimento, new ArrayList<Consulta>()); // Precisa atualizar o histórico médico também!
            pacienteServico.atualizar(cpf, novoNome, novoCpf, novaDataNascimento);
            pacienteInterface.exibirMensagemInfo("Paciente atualizado com sucesso!");
        } catch (DadoInvalidoException e) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
    }

    public void excluirPaciente(String cpf) {

        try {
            if (validarCpf(cpf) != ResultadoCpf.SUCESSO) {
                throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
            }
            pacienteServico.excluir(cpf);
            pacienteInterface.exibirMensagemInfo("Registro do paciente com o " + cpf + " foi excluído com sucesso!");
        } catch (DadoInvalidoException e) {
            pacienteInterface.exibirMensagemErro(e.getMessage());
        }
    }

    public static enum ResultadoCpf
    {
        PADRAO_INVALIDO,
        SUCESSO,
        DV1_INVALIDO,
        DV2_INVALIDO,
        CPF_JA_CADASTRADO
    }

    public ResultadoCpf validarCpf(String cpf) {

        // Passo "0": O CPF já existe na lista de Pessoas?

        // Passo 1: Segue o formato XXX.XXX.XXX-XX?
        Pattern cpfPattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
        Matcher cpfMatcher = cpfPattern.matcher(cpf);
        if (!cpfMatcher.matches()) return ResultadoCpf.PADRAO_INVALIDO;
        // Passo 2: Os dígitos verificadores são válidos?
        String digitos = cpf.replaceAll("[^\\d]", "");

        // D.V. 1
        int dv = 0;
        for (int i = 0; i < 9; i++)
            dv += Character.getNumericValue(digitos.charAt(i)) * (10 - i);
        int mod11 = dv % 11;
        if (mod11 != Character.getNumericValue(digitos.charAt(9))) return ResultadoCpf.DV1_INVALIDO;

        // D.V. 2
        dv = 0;
        for (int i = 0; i < 10; i++)
            dv += Character.getNumericValue(digitos.charAt(i)) * (11 - i);
        mod11 = dv % 11;
        if (mod11 != Character.getNumericValue(digitos.charAt(10))) return ResultadoCpf.DV2_INVALIDO;

        //m_CPF = CPF;
        return buscarPaciente(cpf) == null ? ResultadoCpf.SUCESSO : ResultadoCpf.CPF_JA_CADASTRADO;
    }
}
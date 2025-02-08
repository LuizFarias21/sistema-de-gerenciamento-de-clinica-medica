package controladores;

import entidades.Consulta;
import entidades.Medico;
import excecoes.DadoInvalidoException;
import interfaces.MedicoInterface;
import servicos.MedicoServico;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicoControlador {
    private MedicoServico medicoServico;
    private MedicoInterface medicoInterface;

    public MedicoControlador(MedicoServico medicoServico) {
        this.medicoServico = medicoServico;
    }

    public void setMedicoInterface(MedicoInterface medicoInterface) {
        this.medicoInterface = medicoInterface;
    }

    public void cadastrarMedico(String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
        ArrayList<Consulta> historicoMedico = new ArrayList<Consulta>();
        Medico medico = new Medico(nome, cpf, dataNascimento, crm, especialidade, historicoMedico);

        try {
            // Validação do CPF
            if (validarCpf(medico.getCpf())) {
                throw new DadoInvalidoException("Cadastro bloqueado! Você precisa digitar um CPF válido!");
            }

            medicoServico.cadastrar(medico); // Cadastrar o médico no serviço

        } catch (DadoInvalidoException e) {
            medicoInterface.exibirMensagemErro(e.getMessage()); // Exibe erro se CPF for inválido
        }
    }

    public Medico buscarMedico(String cpf) {
        try {
            // Validação do CPF
            if (validarCpf(cpf)) {
                throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
            }

            Medico medico = medicoServico.buscar(cpf); // Buscar médico pelo CPF

            if (medico != null) {
                medicoInterface.exibirMensagemInfo("Médico encontrado: " + medico.getNome());
            }

            return medico;
        } catch (DadoInvalidoException e) {
            medicoInterface.exibirMensagemErro(e.getMessage()); // Exibe erro se CPF for inválido
        }
        return null;
    }

    public void listarMedicos() {
        String mensagem = "";

        try {
            ArrayList<Medico> listaMedicos = medicoServico.listar(); // Lista médicos cadastrados

            for (Medico medico : listaMedicos) {
                mensagem +=  medico.getCpf() + " - " + medico.getNome() + "\n"; // Formata a mensagem
            }

            medicoInterface.exibirMensagemInfo(mensagem); // Exibe a lista de médicos

        } catch (DadoInvalidoException e) {
            medicoInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
        }
    }

    public void atualizarMedico(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento, String novoCrm, String novaEspecialidade) {
        try {
            medicoServico.atualizar(cpf, novoNome, novoCpf, novaDataNascimento, novoCrm, novaEspecialidade); // Atualiza os dados do médico
            medicoInterface.exibirMensagemInfo("Médico atualizado com sucesso!"); // Exibe mensagem de sucesso
        } catch (DadoInvalidoException e) {
            medicoInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
        }
    }

    public void excluirMedico(String cpf) {
        try {
            // Validação do CPF
            if (validarCpf(cpf)) {
                throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
            }

            medicoServico.excluir(cpf); // Exclui o médico do serviço
            medicoInterface.exibirMensagemInfo("Registro do médico com o CPF " + cpf + " foi excluído com sucesso!");

        } catch (DadoInvalidoException e) {
            medicoInterface.exibirMensagemErro(e.getMessage()); // Exibe erro se CPF for inválido
        }
    }

    // Método para validar CPF (pode ser modificado conforme sua lógica de validação)
    public boolean validarCpf(String cpf) {
        boolean cpfVazio = cpf.trim().isEmpty();

        if (cpfVazio) {
            return true;
        }

        return false; // Retorna true se CPF for inválido
    }
}

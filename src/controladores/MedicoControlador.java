package controladores;

import entidades.Consulta;
import entidades.Medico;
import excecoes.DadoInvalidoException;
import servicos.MedicoServico;
import visoes.GenericoVisao;
import visoes.MedicoVisao;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicoControlador extends PessoaControlador<Medico> {
    private MedicoServico medicoServico;
    private MedicoVisao medicoVisao;

    public MedicoControlador(MedicoServico medicoServico) {
        super(medicoServico);
        this.medicoServico = medicoServico;
    }

    public void setMedicoVisao(MedicoVisao medicoVisao) {
        this.medicoVisao = medicoVisao;
    }

    public void cadastrar(String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
        ArrayList<Consulta> historicoMedico = new ArrayList<>();
        Medico medico = new Medico(nome, cpf, dataNascimento, crm, especialidade, historicoMedico);

        try {
            medicoServico.cadastrar(medico); // Cadastrar o médico no serviço
            GenericoVisao.exibirMensagemInfo("Cadastro concluído com sucesso!");
        } catch (DadoInvalidoException e) {
            medicoVisao.exibirMensagemErro(e.getMessage()); // Exibe erro se CPF for inválido
        }
    }

    @Override
    public void atualizar() {

    }


//    public Medico buscarMedico(String cpf) {
//        try {
//            // Validação do CPF
//            if (validarCpf(cpf)) {
//                throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
//            }
//
//            Medico medico = medicoServico.buscar(cpf); // Buscar médico pelo CPF
//
//            if (medico != null) {
//                medicoVisao.exibirMensagemInfo("Médico encontrado: " + medico.getNome());
//            }
//
//            return medico;
//        } catch (DadoInvalidoException e) {
//            medicoVisao.exibirMensagemErro(e.getMessage()); // Exibe erro se CPF for inválido
//        }
//        return null;
//    }

//    public void listarMedicos() {
//        String mensagem = "";
//
//        try {
//            ArrayList<Medico> listaMedicos = medicoServico.listar(); // Lista médicos cadastrados
//
//            for (Medico medico : listaMedicos) {
//                mensagem +=  medico.getCpf() + " - " + medico.getNome() + "\n"; // Formata a mensagem
//            }
//
//            medicoVisao.exibirMensagemInfo(mensagem); // Exibe a lista de médicos
//
//        } catch (DadoInvalidoException e) {
//            medicoVisao.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
//        }
//    }

//    public void atualizarMedico(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento, String novoCrm, String novaEspecialidade) {
//        try {
//            medicoServico.atualizar(cpf, novoNome, novoCpf, novaDataNascimento); // Atualiza os dados do médico
//            medicoInterface.exibirMensagemInfo("Médico atualizado com sucesso!"); // Exibe mensagem de sucesso
//        } catch (DadoInvalidoException e) {
//            medicoInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
//        }
//    }

//    public void removerMedico(String cpf) {
//        try {
//            // Validação do CPF
//            if (validarCpf(cpf)) {
//                throw new DadoInvalidoException("Você precisa digitar um CPF válido!");
//            }
//
//            medicoServico.remover(cpf); // Exclui o médico do serviço
//            medicoVisao.exibirMensagemInfo("Registro do médico com o CPF " + cpf + " foi excluído com sucesso!");
//
//        } catch (DadoInvalidoException e) {
//            medicoVisao.exibirMensagemErro(e.getMessage()); // Exibe erro se CPF for inválido
//        }
//    }
}

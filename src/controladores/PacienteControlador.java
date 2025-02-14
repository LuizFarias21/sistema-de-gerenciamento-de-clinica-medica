package controladores;

import entidades.Consulta;
import entidades.Paciente;
import excecoes.DadoInvalidoException;
import servicos.PacienteServico;
import visoes.GenericoVisao;
import visoes.PacienteVisao;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteControlador extends PessoaControlador<Paciente> {

    private PacienteServico pacienteServico;
    private PacienteVisao pacienteVisao;

    public PacienteControlador(PacienteServico pacienteServico) {
        super(pacienteServico);
        this.pacienteServico = pacienteServico;
    }

    public void setPacienteVisao(PacienteVisao pacienteVisao) {
        this.pacienteVisao = pacienteVisao;
    }

    public void cadastrar(String nome, String cpf, LocalDate dataNascimento) {
        ArrayList<Consulta> historicoMedico = new ArrayList<>();
        Paciente paciente = new Paciente(nome, cpf, dataNascimento, historicoMedico);

        try {
            pacienteServico.cadastrar(paciente);
            GenericoVisao.exibirMensagemInfo("Cadastro concluído com sucesso!");
            //GenericoVisao.exibirMensagemInfo(pacienteServico.listar().toString());
        } catch (DadoInvalidoException e ) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }

    @Override
    public void atualizar() {

    }


//    public Paciente buscarPaciente(String cpf) {
//
//        try {
//            Paciente paciente = pacienteServico.buscar(cpf);
//            pacienteVisao.exibirMensagemInfo("Paciente encontrado: " + paciente.getNome());
//            return paciente;
//        } catch (DadoInvalidoException e ) {
//            pacienteVisao.exibirMensagemErro(e.getMessage());
//        }
//        return null;
//    }

//    public void atualizarPaciente(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento) {
//
//        try {
//            //Paciente novoPaciente = new Paciente(novoNome, novoCpf, novaDataNascimento, new ArrayList<Consulta>()); // Precisa atualizar o histórico médico também!
//            pacienteServico.atualizar(cpf, novoNome, novoCpf, novaDataNascimento);
//            pacienteInterface.exibirMensagemInfo("Paciente atualizado com sucesso!");
//        } catch (DadoInvalidoException e) {
//            pacienteInterface.exibirMensagemErro(e.getMessage());
//        }
//    }



//    public void removerPaciente(String cpf) {
//
//        try {
//            pacienteServico.remover(cpf);
//            pacienteVisao.exibirMensagemInfo("Registro do paciente com o " + cpf + " foi excluído com sucesso!");
//        } catch (DadoInvalidoException e) {
//            pacienteVisao.exibirMensagemErro(e.getMessage());
//        }
//    }
}
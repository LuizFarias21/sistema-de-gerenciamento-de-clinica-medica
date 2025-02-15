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

    @Override
    public void cadastrar() {

        String nome = GenericoVisao.solicitarEntrada("Digite o nome do paciente:");
        String cpf = GenericoVisao.solicitarEntrada("Digite o CPF do paciente:");
        LocalDate dataNascimento = GenericoVisao.solicitarEntradaData("Digite da data de nascimento do paciente (YYYY-MM-DD):");
        ArrayList<Consulta> historicoMedico = new ArrayList<>();

        Paciente paciente = new Paciente(nome, cpf, dataNascimento, historicoMedico);

        try {
            pacienteServico.cadastrar(paciente);
            GenericoVisao.exibirMensagemInfo("Cadastro concluído com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }

    @Override
    public void atualizar() {
            
        try {    
            String cpf = GenericoVisao.solicitarEntrada("Digite o CPF do paciente que deseja atualizar os dados:");
            Paciente paciente = pacienteServico.buscar(cpf);
    
            if (paciente == null) {
                GenericoVisao.exibirMensagemErro("Paciente não encontrado!");
                return;
            }
    
            String novoNome = GenericoVisao.solicitarEntrada("Digite o novo nome do paciente:");
            String novoCpf = GenericoVisao.solicitarEntrada("Digite o novo CPF do paciente:");
            LocalDate novaDataNascimento = GenericoVisao.solicitarEntradaData("Digite a nova data de nascimento do paciente (YYYY-MM-DD):");
    
            
            Paciente novoPaciente = new Paciente(novoNome, novoCpf, novaDataNascimento, paciente.getHistoricoMedico());
            pacienteServico.atualizar(paciente, novoPaciente);
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
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

//    @Override
//    public void atualizar() {
//        String novoCpf = JOptionPane.showInputDialog("Digite o novo CPF do paciente:");
//        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do paciente:");
//        LocalDate novaDataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite a nova data de nascimento do paciente (YYYY-MM-DD:)"));
//
//        String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente que deseja atualizar os dados:");
//        pacienteControlador.atualizarPaciente(cpf, novoCpf, novoNome, novaDataNascimento);
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
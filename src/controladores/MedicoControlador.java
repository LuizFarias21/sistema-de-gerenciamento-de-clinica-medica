package controladores;

import entidades.Consulta;
import entidades.Medico;
import excecoes.DadoInvalidoException;
import servicos.MedicoServico;
import visoes.GenericoVisao;
import visoes.MedicoVisao;

import javax.swing.*;
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

    @Override
    public void cadastrar() {
        String nome = GenericoVisao.solicitarEntrada("Digite o nome do médico:");
        String cpf = GenericoVisao.solicitarEntrada("Digite o CPF do médico:");
        LocalDate dataNascimento = GenericoVisao.solicitarEntradaData("Digite da data de nascimento do médico (YYYY-MM-DD):");
        String crm = GenericoVisao.solicitarEntrada("Digite o crm do Médico:");
        String especialidade = GenericoVisao.solicitarEntrada("Digite a especialidade do médico:");

        ArrayList<Consulta> historicoMedico = new ArrayList<>();
        Medico medico = new Medico(nome, cpf, dataNascimento, crm, especialidade, historicoMedico);

        try {
            medicoServico.cadastrar(medico); // Cadastrar o médico no serviço
            GenericoVisao.exibirMensagemInfo("Cadastro concluído com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage()); // Exibe erro se CPF for inválido
        }
    }

    @Override
    public void atualizar() {

    }

//    public void atualizarMedico(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento, String novoCrm, String novaEspecialidade) {
//        try {
//            medicoServico.atualizar(cpf, novoNome, novoCpf, novaDataNascimento); // Atualiza os dados do médico
//            medicoInterface.exibirMensagemInfo("Médico atualizado com sucesso!"); // Exibe mensagem de sucesso
//        } catch (DadoInvalidoException e) {
//            medicoInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja algum problema
//        }
//    }

//    @Override
//    public void atualizar() {
//        String novoCpf = JOptionPane.showInputDialog("Digite o novo CPF do médico:");
//        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do médico:");
//        LocalDate novaDataNascimento = LocalDate.parse(JOptionPane.showInputDialog("Digite a nova data de nascimento do médico (YYYY-MM-DD):"));
//        String novoCrm = JOptionPane.showInputDialog("Digite o novo CRM do médico:");
//        String novaEspecialidade = JOptionPane.showInputDialog("Digite a nova especialidade do médico:");
//
//        String cpf = JOptionPane.showInputDialog("Digite o CPF do médico que deseja atualizar os dados:");
//        medicoControlador.atualizarMedico(cpf, novoNome, novoCpf, novaDataNascimento, novoCrm, novaEspecialidade);
//    }
}

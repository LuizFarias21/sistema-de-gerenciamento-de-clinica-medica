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

    // E preciso depois procurar uma maneira de atualizar o historicoMedico tambem!
    @Override
    public void atualizar() {

        try {
            ArrayList<Medico> listaPacientes = medicoServico.listar();
            String cpf = GenericoVisao.solicitarEntrada(imprimirLista(listaPacientes) + "Digite o CPF do medico que deseja atualizar os dados:");
            Medico medico = medicoServico.buscar(cpf);

            if (medico == null) {
                GenericoVisao.exibirMensagemErro("Medico não encontrado!");
                return;
            }

            String novoNome = GenericoVisao.solicitarEntrada("Digite o novo nome do médico:");
            String novoCpf = GenericoVisao.solicitarEntrada("Digite o novo CPF do médico:");
            LocalDate novaDataNascimento = GenericoVisao.solicitarEntradaData("Digite a nova da data de nascimento do médico (YYYY-MM-DD):");
            String novoCrm = GenericoVisao.solicitarEntrada("Digite o novo CRM do Médico:");
            String novaEspecialidade = GenericoVisao.solicitarEntrada("Digite a nova especialidade do médico:");

            Medico novoMedico = new Medico(novoNome, novoCpf, novaDataNascimento, novoCrm, novaEspecialidade, medico.getHistoricoMedico());
            medicoServico.atualizar(medico, novoMedico);
            GenericoVisao.exibirMensagemInfo("Medico atualizado com sucesso!");
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
    }
}

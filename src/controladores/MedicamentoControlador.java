package controladores;

import entidades.Medicamento;
import servicos.MedicamentoServico;
import excecoes.DadoInvalidoException;

public class MedicamentoControlador extends ClinicaControlador<Medicamento> {

    private MedicamentoServico medicamentoServico;

    public MedicamentoControlador(MedicamentoServico medicamentoServico) {
        this.medicamentoServico = medicamentoServico;
    }

    public void cadastrar(Medicamento medicamento) throws DadoInvalidoException {
        medicamentoServico.cadastrar(medicamento); // Chama o serviço para cadastrar
    }

    public void buscar(String nome) throws DadoInvalidoException {
        Medicamento medicamento = medicamentoServico.buscar(nome); // Busca o medicamento pelo nome
		if (medicamento != null) {
		    System.out.println("Medicamento encontrado: " + medicamento.getNome());
		} else {
		    System.out.println("Medicamento não encontrado.");
		}
    }

    public void listar() throws DadoInvalidoException {
        medicamentoServico.listar(); // Lista os medicamentos cadastrados
    }

    public void excluir(String nome) throws DadoInvalidoException {
        medicamentoServico.excluir(nome); // Exclui o medicamento
		System.out.println("Medicamento excluído com sucesso!");
    }
}

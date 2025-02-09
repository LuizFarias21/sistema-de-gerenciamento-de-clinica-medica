package controladores;

import entidades.Medicamento;
import repositorios.MedicamentoRepositorio;

import java.time.LocalDate;
import java.util.List;

public class MedicamentoControlador {

    private MedicamentoRepositorio medicamentoRepositorio;

    public MedicamentoControlador(MedicamentoRepositorio medicamentoRepositorio) {
        this.medicamentoRepositorio = medicamentoRepositorio;
    }

    // Cadastrar medicamento
    public void cadastrarMedicamento(String nome, String laboratorio, LocalDate validade) {
        Medicamento medicamento = new Medicamento(nome);
        medicamentoRepositorio.salvar(medicamento);
        System.out.println("Medicamento cadastrado com sucesso.");
    }

    // Buscar medicamento por nome
    public void buscarMedicamento(String nome) {
        Medicamento medicamento = medicamentoRepositorio.buscarPorNome(nome);
        if (medicamento != null) {
            System.out.println("Medicamento encontrado: " + medicamento);
        } else {
            System.out.println("Medicamento não encontrado.");
        }
    }

    // Listar todos os medicamentos
    public void listarMedicamentos() {
        List<Medicamento> medicamentos = medicamentoRepositorio.listar();
        if (!medicamentos.isEmpty()) {
            System.out.println("Lista de medicamentos:");
            medicamentos.forEach(medicamento -> System.out.println(medicamento));
        } else {
            System.out.println("Nenhum medicamento encontrado.");
        }
    }

    // Atualizar medicamento
    public void atualizarMedicamento(String nome, String novoNome, String novoLaboratorio, LocalDate novaValidade) {
        Medicamento medicamento = medicamentoRepositorio.buscar(nome);
        if (medicamento != null) {
            medicamento.setNome(novoNome);
            medicamento.setLaboratorio(novoLaboratorio);
            medicamento.setValidade(novaValidade);
            medicamentoRepositorio.atualizar(medicamento);
            System.out.println("Medicamento atualizado com sucesso.");
        } else {
            System.out.println("Medicamento não encontrado.");
        }
    }

    // Deletar medicamento
    public void excluirMedicamento(String nome) {
        Medicamento medicamento = medicamentoRepositorio.buscar(nome);
        if (medicamento != null) {
            medicamentoRepositorio.remover(medicamento);
            System.out.println("Medicamento removido com sucesso.");
        } else {
            System.out.println("Medicamento não encontrado.");
        }
    }
}

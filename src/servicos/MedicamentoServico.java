package servicos;

import java.util.ArrayList;

import controladores.MedicamentoControlador;
import entidades.Medicamento;
import repositorios.MedicamentoRepositorio;

public class MedicamentoServico extends ClinicaServico<Medicamento> {

    public MedicamentoServico(MedicamentoRepositorio medicamentoRepositorio) {
        super();
    }

    public void cadastrar(Medicamento medicamento) {
        // Lógica de cadastro do medicamento
        MedicamentoServico.salvar(medicamento);
    }

    public Medicamento buscar(String nome) {
        // Busca medicamento pelo nome
        return MedicamentoServico.buscar(nome);
    }

    public ArrayList listar() {
        // Lista todos os medicamentos
        for (Medicamento medicamento : medicamento.listar()) {
            System.out.println(medicamento.getNome());
        }
    }

    public void excluir(String nome) {
        // Exclui medicamento pelo nome
        MedicamentoControlador.excluir(nome);
    }
}

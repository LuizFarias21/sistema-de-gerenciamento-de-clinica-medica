package controladores;

import entidades.Exame;
import repositorios.ExameRepositorio;

import java.time.LocalDate;
import java.util.List;

public class ExameControlador {

    private ExameRepositorio exameRepositorio;

    public ExameControlador(ExameRepositorio exameRepositorio) {
        this.exameRepositorio = exameRepositorio;
    }

    // Cadastrar exame
    public void cadastrarExame(String nome, LocalDate dataExame, String tipo) {
        Exame exame = new Exame(nome, dataExame, tipo);
        exameRepositorio.salvar(exame);
        System.out.println("Exame cadastrado com sucesso.");
    }

    // Buscar exame por nome
    public void buscarExame(String nome) {
        Exame exame = exameRepositorio.buscar(nome);
        if (exame != null) {
            System.out.println("Exame encontrado: " + exame);
        } else {
            System.out.println("Exame não encontrado.");
        }
    }

    // Listar todos os exames
    public void listarExames() {
        List<Exame> exames = exameRepositorio.listar();
        if (!exames.isEmpty()) {
            System.out.println("Lista de exames:");
            exames.forEach(exame -> System.out.println(exame));
        } else {
            System.out.println("Nenhum exame encontrado.");
        }
    }

    // Atualizar exame
    public void atualizarExame(String nome, String novoNome, LocalDate novaDataExame, String novoTipo) {
        Exame exame = exameRepositorio.buscar(nome);
        if (exame != null) {
            exame.setNome(novoNome);
            exame.setDataExame(novaDataExame);
            exame.setTipo(novoTipo);
            exameRepositorio.atualizar(exame);
            System.out.println("Exame atualizado com sucesso.");
        } else {
            System.out.println("Exame não encontrado.");
        }
    }

    // Deletar exame
    public void excluirExame(String nome) {
        Exame exame = exameRepositorio.buscar(nome);
        if (exame != null) {
            exameRepositorio.remover(exame);
            System.out.println("Exame removido com sucesso.");
        } else {
            System.out.println("Exame não encontrado.");
        }
    }
}

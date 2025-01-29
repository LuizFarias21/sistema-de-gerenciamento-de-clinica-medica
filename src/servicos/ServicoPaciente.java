package servicos;

import entidades.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServicoPaciente extends ServicosCrud<Paciente> {

    private ArrayList<Paciente> pacientes = new ArrayList<>();

    @Override
    public void adicionar(Paciente paciente) {
        if(buscar(paciente.getCpf()) == null){
            pacientes.add(paciente);
            System.out.println("Paciente adicionado com sucesso");
        } else {
            System.out.println("Já existe esse paciente!");
        }
    }

    @Override
    public Paciente buscar(String cpf) {
        for (Paciente paciente : pacientes){
            if(paciente.getCpf().equals(cpf)){
                return paciente;
            }
        }
        return null;
    }

    public void atualizarPaciente(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento) {
        Paciente paciente = buscar(cpf);
        if(paciente != null){
            paciente.setNome(novoNome);
            paciente.setCpf(novoCpf);
            paciente.setDataNascimento(novaDataNascimento);
            System.out.println("Paciente atualizado com sucesso");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    @Override
    public void remover(String cpf) {
        Paciente paciente = buscar(cpf);
        if(paciente != null){
            pacientes.remove(paciente);
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}

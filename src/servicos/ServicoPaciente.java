package servicos;

import entidades.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServicoPaciente extends ServicosCRUD<Paciente> {


    @Override
    public void adicionar(Paciente paciente) {
        if(buscar(paciente.getCPF()) == null){
            lista.add(paciente);
            System.out.println("Paciente adicionado com sucesso");
        } else {
            System.out.println("Já existe esse paciente!");
        }
    }

    // Falta implementar a condicao de bloquear cadastro se CPF já estiver registrado.
    @Override
    public Paciente buscar(String CPF) {
        for (Paciente paciente : lista){
            if(paciente.getCPF().equals(CPF)){
                return paciente;
            }
        }
        return null;
    }

    //(ideias) ------ gdgdgd.buscar(CPF).atualizar(Classe objeto);

    @Override
    public void atualizar(String CPF, Paciente novo) {
        Paciente paciente = buscar(CPF);
        if (paciente != null)
        {
            paciente.setNome(novo.getNome());
            paciente.setCPF(novo.getCPF());
            paciente.setDataNascimento(novo.getDataNascimento());
            System.out.println("Paciente atualizado com sucesso");
        }
        else System.out.println("Paciente não encontrado.");
    }

    @Override
    public void remover(String CPF) {
        Paciente paciente = buscar(CPF);
        if(paciente != null){
            lista.remove(paciente);
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}

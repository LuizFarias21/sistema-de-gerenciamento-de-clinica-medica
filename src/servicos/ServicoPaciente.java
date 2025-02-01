package servicos;

import entidades.Paciente;

public class ServicoPaciente extends ServicosCRUD<Paciente> {

    @Override
    public void adicionar(Paciente paciente) {
        if(buscar(paciente.getCPF()) == null){
            lista.add(paciente);
            System.out.println("Paciente " + paciente.getNome() + " adicionado com sucesso");
        } else {
            System.out.println("CPF ja consta no registro de pacientes, cadastro bloqueado");
        }
    }

    @Override
    public Paciente buscar(String CPF) {
        for (Paciente paciente : lista){
            if(paciente.getCPF().equals(CPF)){
                return paciente;
            }
        }
        return null;
    }

    @Override
    public void atualizar(String CPF, Paciente novoPaciente) {
        Paciente paciente = buscar(CPF);
        if (paciente != null)
        {
            paciente.setNome(novoPaciente.getNome());
            paciente.setCPF(novoPaciente.getCPF());
            paciente.setDataNascimento(novoPaciente.getDataNascimento());
            System.out.println("Paciente " + novoPaciente.getNome() + " atualizado com sucesso!");

        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    @Override
    public void remover(String CPF) {
        Paciente paciente = buscar(CPF);
        if(paciente != null){
            lista.remove(paciente);
            System.out.println("Paciente " + paciente.getNome() + " removido com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}

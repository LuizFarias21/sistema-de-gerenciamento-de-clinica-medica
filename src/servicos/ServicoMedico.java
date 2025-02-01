package servicos;

import entidades.Medico;

public class ServicoMedico extends ServicosCRUD<Medico> {

    @Override
    public void adicionar(Medico medico) {
        if(buscar(medico.getCPF()) == null){
            lista.add(medico);
            System.out.println("Medico " + medico.getNome() + " adicionado com sucesso");
        } else {
            System.out.println("CPF ja consta no registro de medicos, cadastro bloqueado");
        }
    }

    @Override
    public Medico buscar(String cpf) {
        for (Medico medico : lista){
            if(medico.getCPF().equals(cpf)){
                return medico;
            }
        }
        return null;
    }

    @Override
    public void atualizar(String CPF, Medico novoMedico) {
        Medico medico = buscar(CPF);
        if(medico != null){
            medico.setNome(novoMedico.getNome());
            medico.setCPF(novoMedico.getCPF());
            medico.setDataNascimento(novoMedico.getDataNascimento());
            medico.setCrm(novoMedico.getCrm());
            medico.setEspecialidade(novoMedico.getEspecialidade());
            System.out.println("Medico " + novoMedico.getNome() + " atualizado com sucesso!");
        } else {
            System.out.println("Medico não encontrado.");
        }
    }

    @Override
    public void remover(String CPF) {
        Medico medico = buscar(CPF);
        if(medico != null){
            lista.remove(medico);
            System.out.println("Medico " + medico.getNome() + " removido com sucesso.");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}

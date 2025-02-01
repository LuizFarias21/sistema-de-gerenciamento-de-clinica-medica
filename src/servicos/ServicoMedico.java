package servicos;

import entidades.Medico;

//  import java.time.LocalDate;
//  import java.util.ArrayList;

public class ServicoMedico extends ServicosCRUD<Medico> {

    @Override
    public void adicionar(Medico medico) {
        if(buscar(medico.getCPF()) == null){
            lista.add(medico);
            System.out.println("Médico adicionado com sucesso");
        } else {
            System.out.println("Já existe esse Médico!");
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
    public void atualizar(String CPF, Medico novo) {
        Medico medico = buscar(CPF);
        if(medico != null){
            medico.setNome(novo.getNome());
            medico.setCPF(novo.getCPF());
            medico.setDataNascimento(novo.getDataNascimento());
            medico.setCrm(novo.getCrm());
            medico.setEspecialidade(novo.getEspecialidade());
            System.out.println("Medico atualizado com sucesso");
        } else {
            System.out.println("Medico não encontrado.");
        }
    }

    @Override
    public void remover(String CPF) {
        Medico medico = buscar(CPF);
        if(medico != null){
            lista.remove(medico);
            System.out.println("Médico removido com sucesso.");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}

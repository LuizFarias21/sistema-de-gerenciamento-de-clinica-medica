package servicos;

import entidades.Medico;
import entidades.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;

public class ServicoMedico extends ServicosCrud<Medico> {

    private ArrayList<Medico> medicos = new ArrayList<>();

    @Override
    public void adicionar(Medico medico) {
        if(buscar(medico.getCpf()) == null){
            medicos.add(medico);
            System.out.println("Médico adicionado com sucesso");
        } else {
            System.out.println("Já existe esse Médico!");
        }
    }

    @Override
    public Medico buscar(String cpf) {
        for (Medico medico : medicos){
            if(medico.getCpf().equals(cpf)){
                return medico;
            }
        }
        return null;
    }

    public void atualizarMedico(String cpf, String novoNome, String novoCpf, LocalDate novaDataNascimento, String novoCrm, String novaEspecialidade) {
        Medico medico = buscar(cpf);
        if(medico != null){
            medico.setNome(novoNome);
            medico.setCpf(novoCpf);
            medico.setDataNascimento(novaDataNascimento);
            medico.setCrm(novoCrm);
            medico.setEspecialidade(novaEspecialidade);
            System.out.println("Medico atualizado com sucesso");
        } else {
            System.out.println("Medico não encontrado.");
        }
    }

    @Override
    public void remover(String cpf) {
        Medico medico = buscar(cpf);
        if(medico != null){
            medicos.remove(medico);
            System.out.println("Médico removido com sucesso.");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }
}

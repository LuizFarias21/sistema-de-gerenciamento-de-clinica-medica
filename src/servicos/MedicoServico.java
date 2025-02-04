package servicos;

import entidades.Medico;

public class MedicoServico extends PessoaServico<Medico> {

    @Override
    public boolean atualizar(Medico medico, Medico novoMedico) {

        if(medico != null){

            medico.setNome(novoMedico.getNome());
            medico.setCpf(novoMedico.getCpf());
            medico.setDataNascimento(novoMedico.getDataNascimento());
            medico.setCrm(novoMedico.getCrm());
            medico.setEspecialidade(novoMedico.getEspecialidade());

            return true;
        }

        return false;
    }

}

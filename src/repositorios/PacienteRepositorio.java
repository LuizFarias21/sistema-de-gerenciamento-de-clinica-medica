package repositorios;

import entidades.Paciente;

public class PacienteRepositorio extends PessoaRepositorio<Paciente> {

    @Override
    public boolean atualizar(Paciente paciente, Paciente novoPaciente) {
        if (paciente != null) {

            paciente.setNome(novoPaciente.getNome());
            paciente.setCpf(novoPaciente.getCpf());
            paciente.setDataNascimento(novoPaciente.getDataNascimento());

            return true;
        }
        return false;
    }
}

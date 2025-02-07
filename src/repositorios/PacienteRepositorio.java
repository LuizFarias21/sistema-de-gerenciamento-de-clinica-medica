package repositorios;

import entidades.Paciente;

public class PacienteRepositorio extends PessoaRepositorio<Paciente> {

    @Override
    public void atualizar(Paciente paciente, Paciente novoPaciente) {
            paciente.setNome(novoPaciente.getNome());
            paciente.setCpf(novoPaciente.getCpf());
            paciente.setDataNascimento(novoPaciente.getDataNascimento());
    }
}

package servicos;

import entidades.Consulta;
import entidades.Pessoa;

public class PessoaServico {

    public void adicionarConsulta(Consulta consulta, Pessoa pessoa) {
        pessoa.getHistoricoMedico().add(consulta);
    }
}

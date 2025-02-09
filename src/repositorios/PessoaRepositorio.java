package repositorios;

import entidades.Pessoa;

public abstract class PessoaRepositorio<TipoPessoa extends Pessoa> extends GenericoRepositorio<TipoPessoa> {

    @Override
    public TipoPessoa buscar(String cpf) {
        for (TipoPessoa tipoPessoa : listar()){
            if(tipoPessoa.getCpf().equals(cpf)){
                return tipoPessoa;
            }
        }
        return null;
    }
}
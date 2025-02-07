package repositorios;

import entidades.Pessoa;

public abstract class PessoaRepositorio<TipoPessoa extends Pessoa> extends BaseRepositorio<TipoPessoa> {

    @Override
    public void salvar(TipoPessoa pessoa) {
        getLista().add(pessoa);

    }

    @Override
    public TipoPessoa buscar(String cpf) {
        for (TipoPessoa pessoa : getLista()){
            if(pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return null;
    }
}

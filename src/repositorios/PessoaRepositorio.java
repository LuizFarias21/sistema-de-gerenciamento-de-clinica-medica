package repositorios;

import entidades.Pessoa;

public abstract class PessoaRepositorio<T extends Pessoa> extends BaseRepositorio<T> {

    @Override
    public T buscar(String cpf) {
        for (T pessoa : listar()){
            if(pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return null;
    }
}
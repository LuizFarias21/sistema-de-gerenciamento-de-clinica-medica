package repositorios;

import entidades.Pessoa;
import java.util.ArrayList;

public abstract class PessoaRepositorio<TipoPessoa extends Pessoa> extends GenericoRepositorio<TipoPessoa> {

    private static final ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    @Override
    public void cadastrar(TipoPessoa tipoPessoa) {
        super.cadastrar(tipoPessoa);
        listaPessoas.add(tipoPessoa);
    }

    @Override
    public TipoPessoa buscar(String cpf) {
        for (TipoPessoa pessoa : getLista()){
            boolean cpfCorrespondente = pessoa.getCpf().equals(cpf);
            if(cpfCorrespondente) return pessoa;
        }
        return null;
    }

    @Override
    public void atualizar(TipoPessoa pessoa, TipoPessoa novaPessoa) {
        super.atualizar(pessoa, novaPessoa);
        listaPessoas.set(listaPessoas.indexOf(pessoa), novaPessoa);
    }

    @Override
    public void remover(TipoPessoa tipoPessoa) {
        super.remover(tipoPessoa);
        listaPessoas.remove(tipoPessoa);
    }

    public ArrayList<Pessoa> getListaPessoas() {
        return listaPessoas;
    }
}
package servicos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.spi.DirStateFactory.Result;

import entidades.Pessoa;
import excecoes.CadastroBloqueadoException;

//import javax.swing.*;

public class PessoaServico<TipoPessoa extends Pessoa> extends CrudServico<TipoPessoa> {

    @Override
    public void salvar(TipoPessoa pessoa) throws CadastroBloqueadoException {

        ResultadoCPF resultado = validarCpf(pessoa.getCpf());
        if (resultado == ResultadoCPF.SUCESSO) getListaEntidades().add(pessoa);
        else throw new CadastroBloqueadoException(pessoa, resultado);
    }

    @Override
    public TipoPessoa buscar(String cpf) throws IllegalArgumentException{
        if (cpf.isEmpty()) throw new IllegalArgumentException("O CPF não pode ser vazio.");
        for (TipoPessoa pessoa : getListaEntidades()){
            if(pessoa.getCpf().equals(cpf)){
                return pessoa;
            }
        }
        return null;
    }

    @Override
    public boolean atualizar(TipoPessoa pessoa, TipoPessoa novaPessoa) {
        if (pessoa != null) {

            pessoa.setNome(novaPessoa.getNome());
            pessoa.setCpf(novaPessoa.getCpf());
            pessoa.setDataNascimento(novaPessoa.getDataNascimento());

            return true;
        }
        return false;
    }

    public static enum ResultadoCPF
    {
        PADRAO_INVALIDO,
        SUCESSO,
        DV1_INVALIDO,
        DV2_INVALIDO,
        CPF_JA_CADASTRADO
    }

    public ResultadoCPF validarCpf(String CPF)
    {
        // Passo "0": O CPF já existe na lista de Pessoas?
        
        // Passo 1: Segue o formato XXX.XXX.XXX-XX?
        Pattern cpfPattern = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}");
        Matcher cpfMatcher = cpfPattern.matcher(CPF);
        if (!cpfMatcher.matches()) return ResultadoCPF.PADRAO_INVALIDO;
        // Passo 2: Os dígitos verificadores são válidos?
        String digitos = CPF.replaceAll("[^\\d]", "");

        // D.V. 1
        int dv = 0;
        for (int i = 0; i < 9; i++)
            dv += Character.getNumericValue(digitos.charAt(i)) * (10 - i);
        int mod11 = dv % 11;
        if (mod11 != Character.getNumericValue(digitos.charAt(9))) return ResultadoCPF.DV1_INVALIDO;

        // D.V. 2
        dv = 0;
        for (int i = 0; i < 10; i++)
            dv += Character.getNumericValue(digitos.charAt(i)) * (11 - i);
        mod11 = dv % 11;
        if (mod11 != Character.getNumericValue(digitos.charAt(10))) return ResultadoCPF.DV2_INVALIDO;

        //m_CPF = CPF;
        return buscar(CPF) == null ? ResultadoCPF.SUCESSO : ResultadoCPF.CPF_JA_CADASTRADO;
    }
}

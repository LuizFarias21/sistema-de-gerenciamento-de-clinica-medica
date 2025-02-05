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

    public interface ResultadoCPF // String = mensagem[/causa] de erro
    {
        String PADRAO_INVALIDO = "Este CPF está em padrão inválido, insira-o no padrão XXX.XXX.XXX-XX.";
        String SUCESSO = "Erro desconhecido.";
        String DV1_INVALIDO = "O 1º dígito verificador (o penúltimo no geral) deste CPF está inválido.";
        String DV2_INVALIDO = "O 2º dígito verificador (o último no geral) deste CPF está inválido.";
        String CPF_JA_CADASTRADO = "Este CPF já está cadastrado.";
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

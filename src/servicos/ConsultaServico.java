package servicos;

import entidades.*;

public class ConsultaServico extends CrudServico<Consulta> {

    @Override
    public void salvar(Consulta consulta) {
        getListaEntidades().add(consulta);
    }

    @Override
    public Consulta buscar(String ID) throws IllegalArgumentException {
        if (ID.isEmpty()) throw new IllegalArgumentException("O ID não pode ser vazio.");
        for (Consulta consulta : getListaEntidades()) {
            if (consulta.getId().equals(ID)){
                return consulta;
            }
        }
        return null;
    }

    @Override
    public boolean atualizar(Consulta consulta, Consulta novaConsulta) {
        if (consulta != null) {

            // Atualizar consulta aqui

            return true;
        }
        return false;
    }

}

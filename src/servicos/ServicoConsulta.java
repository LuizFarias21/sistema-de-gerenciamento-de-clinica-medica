package servicos;

import entidades.*;

public class ServicoConsulta extends ServicoCRUD<Consulta> {

    @Override
    public void salvar(Consulta consulta) {
        getListaEntidades().add(consulta);
    }

    @Override
    public Consulta buscar(String ID) {
        for (Consulta consulta : getListaEntidades()) {
            if (consulta.getID().equals(ID)){
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

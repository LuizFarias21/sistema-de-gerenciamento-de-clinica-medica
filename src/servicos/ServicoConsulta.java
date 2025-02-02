package servicos;

import entidades.*;

public class ServicoConsulta extends ServicosCRUD<Consulta> {

    @Override
    public void adicionar(Consulta consulta) {
        if(buscar(consulta.getID()) == null){
            lista.add(consulta);
            System.out.println("Consulta[" + consulta.getID() + "] adicionada com sucesso!");
        } else {
            System.out.println("Ja existe essa consulta!");
        }
    }

    @Override
    public Consulta buscar(String ID) {
        for (Consulta consulta : lista) {
            if (consulta.getID().equals(ID)){
                return consulta;
            }
        }
        return null;
    }

    @Override
    public void atualizar(String ID, Consulta consulta) {
        consulta = buscar(ID);
        if (consulta != null) {
            System.out.println("Consulta atualizada com sucesso");

        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    @Override
    public void remover(String ID) {
        Consulta consulta = buscar(ID);
        if(consulta != null){
            lista.remove(consulta);
            System.out.println("Consulta removida com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}

package servicos;

import entidades.Consulta;

public class ServicoConsulta extends ServicosCRUD<Consulta>{

    @Override
    public void adicionar(Consulta consulta) {
        if(buscar(consulta.getID()) == null){
            lista.add(consulta);
            System.out.println("Consulta adicionada com sucesso!");
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
    public void atualizar(String ID, Consulta novaConsulta) {
        Consulta consulta = buscar(ID);
        if (consulta != null)
        {
            System.out.println("Paciente atualizado com sucesso");
        }
        else System.out.println("Paciente não encontrado.");
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

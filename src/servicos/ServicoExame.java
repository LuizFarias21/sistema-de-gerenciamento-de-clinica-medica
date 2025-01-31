package servicos;

import entidades.Exame;

public class ServicoExame extends ServicosCRUD<Exame>{

    @Override
    public void adicionar(Exame exame) {
        if(buscar(exame.getID()) == null){
            lista.add(exame);
            System.out.println("Exame adicionado com sucesso!");
        } else {
            System.out.println("Ja existe esse Exame!");
        }
    }

    @Override
    public Exame buscar(String ID) {
        for (Exame exame : lista) {
            if (exame.getID().equals(ID)){
                return exame;
            }
        }
        return null;
    }

    @Override
    public void atualizar(String ID, Exame novoExame) {
        Exame exame = buscar(ID);
        if (exame != null)
        {
            System.out.println("Exame atualizado com sucesso");
        }
        else System.out.println("Exame não encontrado.");
    }

    @Override
    public void remover(String ID) {
        Exame exame = buscar(ID);
        if(exame != null){
            lista.remove(exame);
            System.out.println("Consulta removida com sucesso.");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}

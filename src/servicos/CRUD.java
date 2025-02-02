
// ============================== TESTE

//package servicos;
//
//import entidades.Paciente;
//import entidades.Pessoa;
//
//import java.util.ArrayList;
//
//public abstract class CRUD<T extends Pessoa> {
//
//
//    public ArrayList<T> lista = new ArrayList<T>();
//
//    public void adicionar(T t){
//        if(buscar(t.getCPF()) == null){
//            lista.add(t);
//            System.out.println(t.getClass().getSimpleName() + t.getNome() + " adicionado com sucesso");
//        } else {
//            System.out.println("CPF ja consta no registro de pacientes, cadastro bloqueado");
//        }
//    }
//
//    public T buscar(String ID){
//        for (T t : lista){
//            if(t.getCPF().equals(ID)){
//                return t;
//            }
//        }
//        return null;
//    }
//
//    public void atualizar(String ID, T novo){
//        T t = buscar(ID);
//        if (t != null)
//        {
//            t.setNome(novo.getNome());
//            t.setCPF(novo.getCPF());
//            t.setDataNascimento(novo.getDataNascimento());
//            System.out.println("Paciente " + novo.getNome() + " atualizado com sucesso!");
//
//        } else {
//            System.out.println("Paciente não encontrado.");
//        }
//    }
//
//    public void remover(String ID){
//        T t = buscar(ID);
//        if(t != null){
//            lista.remove(t);
//            System.out.println("Paciente " + t.getNome() + " removido com sucesso.");
//        } else {
//            System.out.println("Paciente não encontrado.");
//        }
//    }
//}
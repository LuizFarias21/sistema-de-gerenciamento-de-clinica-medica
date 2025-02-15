package entidades;

public abstract class Tratamento {
    private String id;
    private int idNumerico = Integer.parseInt(id);
    private final String idIncrementado = Integer.toString(idNumerico++);

    public Tratamento() {
        this.id = idIncrementado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

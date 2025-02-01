package entidades;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prescricao {

    private Consulta consultaAssociada;
    private Exame examePrescritos;
    private ArrayList<Medicamento> medicamentos;
    private LocalDate dataValidade;

    Prescricao(Consulta consultaAssociada, Exame examePrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {
        this.consultaAssociada = consultaAssociada;
        this.examePrescritos = examePrescritos;
        this.medicamentos = medicamentos;
        this.dataValidade = dataValidade;
    }

    public Consulta getConsultaAssociada() {
        return consultaAssociada;
    }

    public void setConsultaAssociada(Consulta consultaAssociada) {
        this.consultaAssociada = consultaAssociada;
    }

    public Exame getExamePrescritos() {
        return examePrescritos;
    }

    public void setExamePrescritos(Exame examePrescritos) {
        this.examePrescritos = examePrescritos;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}

package entidades;

import java.time.LocalDate;
import java.util.List;

public class Prescricao {

    private Consulta consultaAssociada;
    private Exame examePrescritos;
    private List<Medicamento> medicamentos;
    private LocalDate dataValidade;

    Prescricao(Consulta consultaAssociada, Exame examePrescritos, List<Medicamento> medicamentos, LocalDate dataValidade) {
        this.consultaAssociada = consultaAssociada;
        this.examePrescritos = examePrescritos;
        this.medicamentos = medicamentos;
        this.dataValidade = dataValidade;
    }

}

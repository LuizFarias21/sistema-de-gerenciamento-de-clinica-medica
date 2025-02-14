package controladores;

import entidades.Medicamento;
import servicos.MedicamentoServico;
import visoes.MedicamentoVisao;

public class MedicamentoControlador extends TratamentoControlador<Medicamento> {
    private MedicamentoServico medicamentoServico;
    private MedicamentoVisao medicamentoVisao;

    public MedicamentoControlador(MedicamentoServico medicamentoServico) {
        this.medicamentoServico = medicamentoServico;
    }
}

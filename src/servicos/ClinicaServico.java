package servicos;

import repositorios.ClinicaRepositorio;

public abstract class ClinicaServico<T> {

    private ClinicaRepositorio<T> clinicaRepositorio;

    public ClinicaServico(ClinicaRepositorio<T> clinicaRepositorio) {
        this.clinicaRepositorio = clinicaRepositorio;
    }


}

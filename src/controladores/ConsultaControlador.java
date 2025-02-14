package controladores;

import entidades.Consulta;
import excecoes.DadoInvalidoException;
import servicos.ConsultaServico;
import visoes.ConsultaVisao;
import visoes.GenericoVisao;

import java.util.ArrayList;

public class ConsultaControlador extends TratamentoControlador<Consulta> {

    private ConsultaServico consultaServico;
    private ConsultaVisao consultaVisao;

    public ConsultaControlador(ConsultaServico consultaServico) {
        super(consultaServico);
        this.consultaServico = consultaServico;
    }

    public void setConsultaVisao(ConsultaVisao consultaVisao) {
        this.consultaVisao = consultaVisao;
    }

    @Override
    public String listar() {

        String mensagem = "";

        try {

            ArrayList<Consulta> listaConsultas = consultaServico.listar();

            for (Consulta consulta : listaConsultas) {
                mensagem +=  consulta.getId() + " - " + "Consulta - " + "Data agendada: " + consulta.getDataAgendada() + "\n";
                mensagem += "---------------------------------\n";
            }

            GenericoVisao.exibirMensagemInfo(mensagem);
            return mensagem;
        } catch (DadoInvalidoException e ) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
        return null;
    }

    @Override
    public void cadastrar() {

    }

    @Override
    public Consulta buscar() {
        String id = GenericoVisao.solicitarEntrada(listar() + "\nDigite o ID da consulta:");
        try {
            Consulta consulta = consultaServico.buscar(id);
            GenericoVisao.exibirMensagemInfo("Consulta do ID: " + id + " foi encontrada!\n" + "Status: " + consulta.getStatus().toString());
            return consulta;
        } catch (DadoInvalidoException e) {
            GenericoVisao.exibirMensagemErro(e.getMessage());
        }
        return null;
    }

    @Override
    public void atualizar() {

    }
}

package controladores;

import entidades.Consulta;
import excecoes.DadoInvalidoException;
import servicos.ConsultaServico;
import interfaces.ConsultaInterface;

public class ConsultaControlador {
    private ConsultaServico consultaServico;
    private ConsultaInterface consultaInterface;

    public ConsultaControlador(ConsultaServico consultaServico) {
        this.consultaServico = consultaServico;
    }

    public void setConsultaInterface(ConsultaInterface consultaInterface) {
        this.consultaInterface = consultaInterface;
    }

    // Criar consulta
//    public void criarConsulta(String id, Paciente paciente, Medico medico, LocalDateTime horario) {
//        // Consulta não tem ID e não aceita somente 4 parâmetros!
//        Consulta consulta = new Consulta(id, paciente, medico, horario);
//
//        try {
//            // Verifica se a consulta já existe
//            if (verificarConflitoDeHorario(consulta)) {
//                throw new DadoInvalidoException("Horário da consulta conflita com outra.");
//            }
//
//            consultaServico.criarConsulta(consulta); // Cria a consulta no serviço
//            consultaInterface.exibirMensagemInfo("Consulta criada com sucesso.");
//
//        } catch (DadoInvalidoException e) {
//            consultaInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso haja conflito de horário ou outro problema
//        }
//    }

    // Buscar consulta por ID
    public void buscarConsulta(String id) {
        try {
            Consulta consulta = consultaServico.buscarConsulta(id); // Busca consulta pelo ID
            consultaInterface.exibirMensagemInfo("Consulta encontrada: " + consulta);
        } catch (DadoInvalidoException e) {
            consultaInterface.exibirMensagemErro(e.getMessage()); // Exibe erro caso consulta não seja encontrada
        }
    }

    // Listar todas as consultas
//    public void listarConsultas() {
//
//        try {
//            ArrayList<Consulta> listaConsultas = consultaServico.listar(); // Lista todas as consultas
//
//            if (listaConsultas.isEmpty()) {
//                consultaInterface.exibirMensagemInfo("Não há consultas cadastradas.");
//            } else {
//                StringBuilder mensagem = new StringBuilder();
//                for (Consulta consulta : listaConsultas) {
//                    mensagem.append(consulta.getId()).append(" - ").append(consulta.getPacienteAssociado().getNome())
//                            .append(" com Dr(a). ").append(consulta.getMedicoResponsavel().getNome()).append("\n");
//                }
//                consultaInterface.exibirMensagemInfo(mensagem.toString()); // Exibe lista de consultas
//            }
//        } catch (DadoInvalidoException e) {
//            consultaInterface.exibirMensagemErro(e.getMessage()); // Exibe erro se houver problema ao listar
//        }
//    }

    // Atualizar consulta existente
//    public void atualizarConsulta(String consultaId, Paciente paciente, Medico medico, LocalDateTime horario) {
//        Consulta consultaAtualizada = new Consulta(consultaId, paciente, medico, horario);
//
//        try {
//            // Verifica se a consulta já existe e se o horário é válido
//            if (verificarConflitoDeHorario(consultaAtualizada)) {
//                throw new DadoInvalidoException("Horário da consulta conflita com outra.");
//            }
//
//            consultaServico.atualizarConsulta(consultaId, consultaAtualizada); // Atualiza a consulta no serviço
//            consultaInterface.exibirMensagemInfo("Consulta atualizada com sucesso.");
//
//        } catch (DadoInvalidoException e) {
//            consultaInterface.exibirMensagemErro(e.getMessage()); // Exibe erro se houver problema ao atualizar
//        }
//    }

    // Remover consulta por ID
    public void removerConsulta(String id) {
        try {
            consultaServico.removerConsulta(id); // Remove consulta do serviço
            consultaInterface.exibirMensagemInfo("Consulta removida com sucesso.");
        } catch (DadoInvalidoException e) {
            consultaInterface.exibirMensagemErro(e.getMessage()); // Exibe erro se não for possível remover
        }
    }

    // Verificação de conflito de horário
//    private boolean verificarConflitoDeHorario(Consulta consulta) {
//        return consultaServico.verificarConflitoDeHorario(consulta); // Verifica se já existe consulta para o mesmo horário
//    }
}

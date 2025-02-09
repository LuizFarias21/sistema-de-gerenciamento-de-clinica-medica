package servicos;

import entidades.Consulta;

public class ConsultaServico extends ClinicaServico<Consulta>{

//    public void agendarConsulta(
//            LocalDate dataAgendada,
//            LocalTime horarioInicialConsulta,
//            LocalTime duracaoConsulta,
//            Paciente pacienteAssociado,
//            Medico medicoResponsavel,
//            Prescricao prescricao,
//            String especialidadeRequerida,
//            double valor) {
//
//        Consulta novaConsulta = new Consulta(dataAgendada, horarioInicialConsulta, duracaoConsulta, Consulta.Status.AGENDADA, pacienteAssociado, medicoResponsavel, prescricao, especialidadeRequerida, valor);
//
//        if (pacienteAssociado == null || medicoResponsavel == null || especialidadeRequerida == null) {
//            throw new IllegalArgumentException("Erro! Você precisa inserir todos os dados corretamente!");
//        }
//        consultaServico.agendarConsulta(novaConsulta);
//    }
//
//    public void cancelarConsulta(Consulta consulta) {
//
//        if (consulta == null) {
//            System.out.println("Não existe essa consulta, portanto não pode ser cancelada!");
//            return;
//        }
//        consultaServico.cancelarConsulta(consulta);
//    }


    //    public void agendarConsulta(Consulta consulta) {
//
//        try {
//
//            if(validarLimiteConsultas(consulta.getMedicoResponsavel())) {
//
//                throw new LimiteConsultaAtingidoException();
//            }
//
//            // Nao permitir realizar agenda se medico nao estiver disponivel
//            if(validarDisponibilidadeMedico(consulta.getMedicoResponsavel(), consulta.getDataAgendada(), consulta.getHorarioInicialConsulta(), consulta.getHorarioFinalConsulta())){
//                throw new HorarioIndisponivelException(consultaConflitante);
//            }
//
//            // Nao permitir realizar agenda se medico nao tiver especialidade requerida
//            if (!validarEspecialidadeMedico(consulta, consulta.getEspecialidadeRequerida())) {
//                throw new EspecialidadeInvalidaException(consulta.getMedicoResponsavel());
//            }
//
//            // Nao permitir realizar agenda se paciente tiver outra consulta no mesmo dia
//            if(validarDisponibilidadePaciente(consulta.getPacienteAssociado(), consulta.getDataAgendada())){
//                throw new PacienteIndisponivelException(consulta.getPacienteAssociado());
//            }
//
//        } catch (LimiteConsultaAtingidoException | HorarioIndisponivelException | PacienteIndisponivelException | EspecialidadeInvalidaException e) {
//            System.out.println("Erro ao agendar consulta: " + e.getMessage());
//            return;
//        }
//
//
//        System.out.println("Horario disponivel! Agendando consulta...");
//        pacienteServico.registrarHistorico(consulta);
//        medicoServico.registrarHistorico(consulta);
//        consultaRepositorio.salvar(consulta);
//
//    }
//
//    public void cancelarConsulta(Consulta consulta) {
//        consulta.setStatus(Consulta.Status.CANCELADA);
//        System.out.println("Consulta cancelada!");
//    }
//
//    public void prescreverTratamento(Consulta consulta, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {
//
//        //consulta.setPrescricao(new Prescricao(consulta, examesPrescritos, medicamentos, dataValidade));
//    }
//
////    public void finalizarConsulta(String identificador, ArrayList<Exame> examesPrescritos, ArrayList<Medicamento> medicamentos, LocalDate dataValidade) {
////
////        for (Consulta consulta : ) {
////
////        }
////
////        if (consulta == null) {
////            System.out.println("Nao existe essa consulta, portanto nao pode ser finalizada!");
////            return;
////        }
////
////        if (consulta.getStatus() == Consulta.Status.AGENDADA) {
////            consulta.setStatus(Consulta.Status.REALIZADA);
////            prescreverTratamento(consulta, examesPrescritos, medicamentos, dataValidade);
////            System.out.println("Consulta " + consulta.getId() + " marcada como REALIZADA.");
////        } else {
////            System.out.println("Apenas consultas AGENDADAS podem ser finalizadas.");
////        }
////    }
//
//    public boolean validarLimiteConsultas(Medico medicoResponsavel) {
//        int limiteConsultasMedico = 6;
//        int consultasAtivas = 0;
//
//        for (Consulta consulta : medicoResponsavel.getHistoricoMedico()) {
//            if (consulta.getStatus() != Consulta.Status.CANCELADA) {
//                consultasAtivas++;
//            }
//        }
//        return consultasAtivas >= limiteConsultasMedico;
//    }
//
//    public boolean validarDisponibilidadeMedico(Medico medicoResponsavel, LocalDate novaData, LocalTime novoInicio, LocalTime novoFim){
//
//        for (Consulta consulta : medicoResponsavel.getHistoricoMedico()){
//
//            if (consulta.getStatus() == Consulta.Status.CANCELADA) continue;
//
//            LocalDate dataAgendada = consulta.getDataAgendada();
//            LocalTime inicioAgendado = consulta.getHorarioInicialConsulta();
//            LocalTime fimAgendado = consulta.getHorarioFinalConsulta().plusHours(duracaoConsulta.getHour()).plusMinutes(duracaoConsulta.getMinute());
//
//            boolean diasIguais = (dataAgendada.equals(novaData));
//            boolean conflitoHorarios = (novoInicio.isBefore(fimAgendado) && novoFim.isAfter(inicioAgendado));
//            boolean conflitoAgenda = diasIguais && conflitoHorarios;
//
//            if (conflitoAgenda) {
//                consultaConflitante = consulta;
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private boolean validarDisponibilidadePaciente(Paciente pacienteAssociado, LocalDate dataConsulta){
//
//        ArrayList<Consulta> historicoMedicoPaciente = pacienteAssociado.getHistoricoMedico();
//        for (Consulta consulta : historicoMedicoPaciente){
//
//            if (consulta.getStatus() == Consulta.Status.CANCELADA) continue;
//            if (pacienteAssociado.getCpf().equals(consulta.getPacienteAssociado().getCpf()) && consulta.getDataAgendada().equals(dataConsulta)) return true; // Paciente ja tem uma consulta esse dia
//        }
//        return false; // Paciente nao tem consulta esse dia
//    }
//
//    private boolean validarEspecialidadeMedico(Consulta consulta, String especialidadeRequerida){
//
//        String especialidadeMedico = consulta.getMedicoResponsavel().getEspecialidade();
//        boolean especialidadeCompativel = especialidadeMedico.equals(especialidadeRequerida);
//
//        return especialidadeCompativel;
//    }
}
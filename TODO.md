# TODO
Uma clínica médica precisa de um sistema para gerenciar consultas, pacientes, médicos, exames e tratamentos. O sistema deve permitir o agendamento de consultas, registro de históricos médicos, prescrição de exames/medicamentos e gestão de pagamentos. Além disso, deve garantir regras de negócio como:

- [ ] Limite de consultas por paciente/médico por dia.
- [ ] Validação de horários e especialidades médicas.
- [ ] Controle de pagamentos pendentes.
- [ ] Notificações para exames agendados ou consultas próximas.

## Enunciado do Trabalho Prático

**Objetivo:** Desenvolver um sistema em Java que aplique os conceitos de orientação a objetos, garantindo modularidade, encapsulamento, herança, polimorfismo e tratamento de exceções personalizadas.

## Requisitos Funcionais:

### Cadastro de Pacientes e Médicos

#### Pacientes:

**Atributos obrigatórios:**
- [x] ``nome`` (string).
- [x] ``CPF``(string XXX.XXX.XXX-XX).
- [x] ``dataNascimento`` (Date ou LocalDate).
- [x] ``HistoricoMedico`` (lista de objetos Consulta e Exame).

**Funcionalidades:**
- [x] CRUD completo de pacientes
- [x] Adicionar uma nova consulta ao histórico.
- [x] Bloquear cadastro se CPF já estiver registrado.

#### Médicos:

**Atributos obrigatórios:**
- [x] ``nome`` (string).
- [x] ``CPF`` (string XXX.XXX.XXX-XX).
- [x] ``dataNascimento``.
- [x] ``CRM``.
- [x] ``especialidade`` (ex: cardiologia, pediatria, etc).
- [x] ``HistoricoMedico`` (lista de objetos Consulta e Exame).

**Funcionalidades:**
- [x] CRUD completo de Médicos.
- [x] Adicionar uma nova consulta ao histórico.
- [x] Bloquear cadastro se CPF já estiver registrado.
#### Agendamento de Consultas

O sistema deverá implementar um CRUD completo para consultas.    
**O sistema deve permitir agendar consultas apenas se:**
- [x] O médico estiver disponível no horário.
- [x] O paciente não tiver outra consulta no mesmo dia.
- [x] O médico tiver a especialidade requerida.

**Para cada consulta médica deverão ser informados, obrigatoriamente:**
- [x] Data da consulta (ex: 26-01-2025).
- [x] Horário de início (ex: 14:30).
- [x] Duração em minutos (padrão: 30 minutos).
- [ ] Status consulta   (Ex.: AGENDADA, CANCELADA, REALIZADA)
- [x] Paciente associado à consulta.
- [x] Médico responsável pela consulta.
- [x] Lista de exames prescritos durante a consulta.
- [x] Lista de medicamentos prescritos.
- [x] Valor da consulta (ex: R$ 150,00).
#### Prescrição de Exames e Medicamentos

- [ ] Médicos podem prescrever exames (ex: sangue, raio-X) ou medicamentos, associando-os à consulta.

- [ ] Tanto para Exames, quanto para Medicamentos, o sistema deverá implementar um CRUD completo.

**No caso de Exame, os atributos obrigatórios são:**
- [ ] ``tipo``: (ex: SANGUE, RAIO_X, ULTRASSOM).
- [x] ``dataPrescricao``: data em que foi prescrito.
- [x] ``dataRealizacao``: data em que foi realizado.
- [ ] ``resultado``: detalhes do resultado, ex: "Colesterol total: 180 mg/dL".
- [ ] ``custo``: valor base do exame.

**No caso de Prescrições (medicamentos, tratamentos, exames), os atributos obrigatórios são:**
- [ ] `consultaAssociada`: associação com a Consulta que gerou a prescrição.
- [ ] ``examesPrescritos``: lista de exames a serem realizados.
- [ ] ``medicamentos``: lista de medicamentos prescritos.
- [ ] ``dataValidade``: prazo para realização dos exames.

#### Gestão de Pagamentos

- [ ] Cada consulta/exame tem um valor associado.
- [ ] Pacientes com pagamentos pendentes não podem agendar novas consultas.

### Tratamento de Exceções

**Exceções deverão ser utilizadas para lidar com as seguintes situações:**
- [ ] Agendamento em horário indisponível.
- [ ] Paciente com pagamento pendente.
- [ ] Médico não encontrado para uma especialidade.



## Requisitos técnicos (conteúdos avaliados):

**Classes e Objetos / Atributos e Métodos / Associações entre Objetos**

- [x] Defina classes como ``Paciente``, ``Medico``, ``Consulta``, ``Exame``, ``Pagamento``, ``Notificacao``, e outras que se fizerem necessárias.
- [ ] Realize as associações entre as classes de modo a considerar o contexto da aplicação. Defina, para cada associação, seu nome e suas multiplicidades.
- [ ] Apresente, através de um diagrama de Classes UML, as classes, seus atributos e métodos, suas associações e multiplicidades, seus pacotes.
- [ ] Explore, o quanto for possível, relações de herança entre as classes que compõem seu projeto.


**Ocultação de Informação e Retenção de Estado**

- [ ] Atributos privados com métodos públicos para acesso (getters/setters).
- [ ] Exemplo: O histórico médico do paciente só pode ser modificado via métodos da classe ``Paciente``, nunca diretamente. Isso vale para todas as outras classes.
- [ ] Acesso direto a elementos definidos em outras classes, somente em relações de herança.


**Modularidade**

Separe o código em pacotes como:
- [x] ``entidades`` (classes base, que descrevem elementos do domínio da aplicação médica).
- [x] ``servicos`` (lógica de agendamento, pagamento).
- [x] ``excecoes`` (exceções customizadas).


**Polimorfismo**

- [ ] Use, o quanto for possível, polimorfismo.
- [ ] Polimorfismo por sobrescrita e sobrecarga de métodos é obrigatório no código.
- [ ] Polimorfismo paramétrico será avaliado pela utilização de generics em Java. Utilize-os, principalmente, ao representar as associações entre objetos.


**Exceções Personalizadas**

Crie as seguintes exceções personalizadas e faça o devido lançamento, conforme descrições abaixo:

- [x] ``HorarioIndisponivelException``: quando vai tentar realizar a marcação de uma consulta para um médico e o horário já está ocupado por uma outra consulta, essa exceção deverá ser lançada e tratada. 
- [ ]  ``PagamentoPendenteException``: quando vai tentar fazer o agendamento de uma consulta ou exame e o paciente possui pendências financeiras registradas no sistema. Nesse caso a exceção deverá ser lançada para impedir o agendamento da consulta ou exame.
- [ ] ``EspecialidadeInvalidaException``: quando tentar realizar a marcação de uma consulta para um médico, mas o médico não possui tal especialidade. Nesse caso a exceção deverá ser lançada para impedir que a marcação da consulta seja realizada.

## Entrega:

Data de entrega: 10/02/2025.

- [ ] Documentação
- [ ] Código Fonte
- [ ] Relatório PDF
- [ ] Diagrama UML

**Relatório em PDF com:**

- [ ] Diagrama de classes UML.
- [ ] Explicação das associações, heranças e polimorfismos aplicados.
- [ ] Justificativa para as exceções customizadas.
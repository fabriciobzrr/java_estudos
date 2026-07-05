const pacientes = [];

function adicionarPaciente(nome) {
  pacientes.push(nome);
}

function adicionarPacientePrioridade(nome) {
  pacientes.unshift(nome);
}

adicionarPaciente("Bruna");
adicionarPaciente("Carlos");
adicionarPaciente("Josias");
adicionarPaciente("Roberio");
adicionarPacientePrioridade("Fabio");
adicionarPacientePrioridade("Roger");

console.log(pacientes);

function atender() {
  const pacienteAtendimento = pacientes.shift();
  return pacienteAtendimento;
}

const pacienteAtendimento = atender();

console.log(`Paciente sendo atendido: ${pacienteAtendimento}\n`);

pacientes.forEach((paciente, i) => {
  console.log(`${i + 1} - ${paciente}`);
});

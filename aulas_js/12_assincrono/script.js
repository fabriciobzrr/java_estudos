function dizerOi() {
  console.log("Olá!")
}

function random() {
  return Math.random() * 5000
}

const tempo = random()
setTimeout(dizerOi, tempo)
console.log("Tempo: " + tempo)

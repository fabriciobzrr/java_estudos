const nomes1 = ["Fred", "Faber", "Billy"]
const nomes2 = ["Fabricio", "Fabra1", "Bicio"]

const tot = nomes1.concat(nomes2)
const todos = [...nomes1, ...nomes2]
console.log(tot)
console.log(todos)

nomes1.forEach((nome) => {
  if (nome === "Billy") {
    nome = "Fabricio"
  }
  console.log(nome)
})

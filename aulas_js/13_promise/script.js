function f(g, h) {
  setTimeout(() => {
    if (10 < 1) {
      g("Tudo nos conformes.")
    } else {
      h("Deu ruim.")
    }
  }, 3000)
}

// function resolvida(resultado) {
//   console.log("Resolvida: " + resultado)
// }

// function rejeitada(erro) {
//   console.log("Rejeitada: " + erro)
// }

const minhaPromessa = new Promise(f)

minhaPromessa
  .then((result) => {
    console.log("Resolvida: " + result)
  })
  .catch((error) => {
    console.log("Rejeitada: " + error)
  })

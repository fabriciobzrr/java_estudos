const cep = "92523666"

const fetchResult = fetch(`https://viacep.com.br/ws/${cep}/json/`)

fetchResult
  .then((resposta) => {
    console.log("DEU CERTO", resposta)
    const json = resposta.json()
    json
      .then((result) => {
        console.log("JSON", result)
      })
      .catch((erro) => {
        console.log("DEU RUIM", erro)
      })
  })
  .catch((erro) => {
    console.log("DEU RUIM", erro)
  })
console.log("Eu executo sozinho")

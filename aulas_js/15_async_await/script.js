const cep = "92523666"

const fetchResult = fetch(`https://viacep.com.br/ws/${cep}/json/`)

async function getResponde(url) {
  const response = await fetch(url)
  const jsonResult = await response.json()
  return jsonResult
}

const result = getResponde(`https://viacep.com.br/ws/${cep}/json/`).then(
  (response) => console.log(response),
)

console.log(result)

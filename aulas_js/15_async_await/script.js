const cep = "92523666"

const fetchResult = fetch(`https://viacep.com.br/ws/${cep}/json/`)

async function getResponse(url) {
  const response = await fetch(url)
  const jsonResult = await response.json()
  return jsonResult
}

async function getResult(cep) {
  const url = `https://viacep.com.br/ws/${cep}/json/`
  const json = await getResponse(url)
  console.log(json)
}

getResult(cep)

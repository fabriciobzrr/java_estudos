function f(g, h) {
  if (10 > 1) {
    g("OK")
  } else {
    h("ERRO")
  }
}

const minhaPromessa = new Promise(f)

minhaPromessa
  .then((result) => {
    console.log(result)
  })
  .catch((error) => {
    console.log(error)
  })

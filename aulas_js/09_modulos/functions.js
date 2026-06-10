function maiorNumero(lista) {
  let maior = lista[0]
  for (let i = 0; i < lista.length; i++) {
    if (lista[i] > maior) {
      maior = lista[i]
    }
  }
  return maior
}
function soma(...valor) {
  let total = 0
  for (let i = 0; i < valor.length; i++) {
    total += valor[i]
  }
  return total
}

export { maiorNumero, soma }

import { maiorNumero, soma } from "./functions.js"
import Product from "./product.js"

const lista = [2, 4, 6, 8, 10]

console.log(soma(...lista))
console.log(maiorNumero(lista))

const teclas = new Product("Teclado", 133, 5)

console.log(teclas.total())

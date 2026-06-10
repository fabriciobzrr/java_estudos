const obj = {
  id: 53,
  date: "2021-10-20",
  items: [
    {
      description: "Celular",
      price: 1499.99,
      quantity: 1,
    },

    {
      description: "Mouse",
      price: 100.0,
      quantity: 2,
    },
  ],

  client: {
    name: "Maria Red",
    email: "maria@gmail.com",
    active: true,
  },
}

const { id, client } = obj
console.log(id)
console.log(client)

function subTotal({ price, quantity }) {
  return price * quantity
}

const total = subTotal(obj.items[0])
console.log("R$", total)

function totalDif({ items }) {
  let soma = 0
  items.forEach((item) => {
    soma += item.price * item.quantity
  })
  return soma
}

console.log("R$", totalDif(obj))

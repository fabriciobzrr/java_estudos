import Order from "./models/order.js"
import * as orderService from "./services/order_service.js"

const data = document.querySelector("#data").value.split("\n")

const order = new Order(data[0], Number(data[1]), Number(data[2]))

const valorTotal = orderService.totalValue(order)

const div = document.createElement("div")
div.innerHTML = `Nº Pedido: ${data[0]}`
div.innerHTML += `<br>Valor Total: R$ ${valorTotal.toFixed(2)}`
document.body.appendChild(div)

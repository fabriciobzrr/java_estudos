export default class Product {
  constructor(name, price, quantity) {
    this.name = name
    this.price = price
    this.quantity = quantity
  }

  total() {
    return `O total é de R$ ${(this.price * this.quantity).toFixed(2)}!`
  }
}

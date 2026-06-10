const product = {
  name: "Mouse",
  price: 140.0,
  quantity: 3,
}

const Product = function (name, price, quantity) {
  this.name = name
  this.price = price
  this.quantity = quantity
}

Product.prototype.total = function () {
  return this.price * this.quantity
}

const mouse = new Product("Teclado", 133, 5)

console.log(product)
console.log(mouse)

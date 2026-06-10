class Product {
  constructor(name, price, quantity) {
    this.name = name
    this.price = price
    this.quantity = quantity
  }

  total() {
    return this.price * this.quantity
  }

  add(quantity) {
    if (quantity < 0) return
    this.quantity += quantity
  }

  remove(quantity) {
    if (quantity > this.quantity) return
    if (quantity < 0) return
    this.quantity -= quantity
  }

  label() {
    console.log(`${this.name} - ${total().toFixed(2)}`)
  }
}

const p1 = new Product("Mouse", 200, 3)
const p2 = new Product("Teclado", 1200, 1)

p1.label()
p2.label()

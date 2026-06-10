const txt = `{"name": "Computador", "price": 3000, "due-date": "2022-01-01"}`

const objeto = JSON.parse(txt)
console.log(objeto)

const text = JSON.stringify(objeto)
console.log(text)

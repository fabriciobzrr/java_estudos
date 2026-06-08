const num = 13

if (num > 12) {
  console.log(`Boa tarde`)
} else if (num > 18) {
  console.log(`Boa noite`)
} else {
  console.log(`Bom dia`)
}

const weekday = 0
switch (weekday) {
  case 0:
    console.log(`Domingo`)
    break
  case 1:
    console.log(`Segunda`)
    break
  case 2:
    console.log(`Terça`)
    break
  case 3:
    console.log(`Quarta`)
    break
  case 4:
    console.log(`Quinta`)
    break
  case 5:
    console.log(`Sexta`)
    break
  case 6:
    console.log(`Sábado`)
    break
  default:
    console.log(`Erro!`)
    break
}

let count = 5
while (count > 0) {
  console.log("Contagem regressiva", count)
  count--
}

do {
  console.log("Contagem regressiva", count)
  count--
} while (count > 0)

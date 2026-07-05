const number1 = document.querySelector("#number1")
const number2 = document.querySelector("#number2")
const buttons = document.querySelectorAll(".btn")
const result = document.querySelector("#result-box")

number1.addEventListener("input", (e) => {
  e.target.value = e.target.value.replace(/[^0-9]/g, "")
})
number1.addEventListener("change", (e) => {
  if (!isNumber(e.target.value)) {
    number1.classList.add("input-error")
  } else {
    number1.classList.remove("input-error")
  }
})

number2.addEventListener("input", (e) => {
  e.target.value = e.target.value.replace(/[^0-9]/g, "")
})
number2.addEventListener("change", (e) => {
  if (!isNumber(e.target.value)) {
    number2.classList.add("input-error")
  } else {
    number2.classList.remove("input-error")
  }
})

buttons.forEach((item) => {
  item.addEventListener("click", (e) => {
    if (e.target.id === "btn-clear") {
      apagarDados()
    } else if (e.target.id === "btn-plus") {
      result.textContent = soma(number1.value, number2.value)
    } else if (e.target.id === "btn-times") {
      result.textContent = multiplicacao(number1.value, number2.value)
    }
  })
})

function soma(number1, number2) {
  return Number(number1) + Number(number2)
}

function multiplicacao(number1, number2) {
  return Number(number1) * Number(number2)
}

function apagarDados() {
  result.textContent = "0"
  number1.value = ""
  number2.value = ""
}

function isNumber(number) {
  return !isNaN(parseFloat(number)) && isFinite(number)
}

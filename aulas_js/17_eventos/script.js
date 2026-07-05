const form = document.querySelector("form")
const nome = form.nome
const email = form.email

nome.addEventListener("keyup", handleInputNameKeyUp)

email.addEventListener("change", handleInputEmailChange)

form.addEventListener("submit", (e) => {
  e.preventDefault()
  console.log("Enviado")
})

function handleInputNameKeyUp(ev) {
  console.log(ev.target.value)
}

function handleInputEmailChange(ev) {
  if (!validateEmail(ev.target.value)) {
    ev.target.classList.remove("success")
    ev.target.classList.add("warning")
    return
  }
  ev.target.classList.remove("warning")
  ev.target.classList.add("success")
}

function validateEmail(email) {
  return String(email)
    .toLowerCase()
    .match(
      /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/,
    )
}

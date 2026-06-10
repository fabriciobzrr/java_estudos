import Employee from "./models/employee.js"
import * as salaryService from "./services/salary_service.js"

const data = document.querySelector("#grossSalaryInput").innerHTML.split("\n")

const employee = new Employee(data[0], Number(data[1]))
const netSalary = salaryService.netSalary(employee)

console.log(`Funcionario = ${employee.name}`)
console.log(`Salario bruto = ${employee.grossSalary.toFixed(2)}`)
console.log(`Salario liquido = ${netSalary.toFixed(2)}`)

const textArea = document.createElement("textarea")

textArea.cols = 30
textArea.rows = 10
textArea.style.fontSize = "24px"
textArea.innerHTML = `
  Funcionário: ${employee.name}
  Salário Bruto: R$ ${employee.grossSalary.toFixed(2)}
  Salário Líquido: R$ ${netSalary.toFixed(2)}
`
document.body.appendChild(textArea)

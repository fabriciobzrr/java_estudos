import * as taxService from "./tax_service.js"
import * as pensionService from "./pension_service.js"

export function netSalary(employee) {
  const tax = taxService.tax(employee.grossSalary)
  const pension = pensionService.discount(employee.grossSalary)

  return employee.grossSalary - tax - pension
}

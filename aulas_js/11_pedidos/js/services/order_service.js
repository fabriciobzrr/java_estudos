import * as shippingService from "./shipping_service.js"

export function totalValue(order) {
  const shipment = shippingService.shipment(order)
  const discount = order.basic * (order.discount / 100)
  return order.basic - discount + shipment
}

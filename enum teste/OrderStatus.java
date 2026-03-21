public enum OrderStatus {
  PENDING_PAYMENT(1),
  PROCESSING(2),
  SHIPPED(3),
  DELIVERED(4);

  private int code;

  private OrderStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public OrderStatus valueOf(int code) {
    for (OrderStatus status : OrderStatus.values()) {
      if (status.getCode() == code) {
        return status;
      }
    }
    throw new IllegalArgumentException("Invalid OrderStatus code");
  }
}

package app;

import db.DB;
import entities.Order;
import entities.OrderStatus;
import entities.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

	public static void main(String[] args) throws SQLException {

		Connection conn = DB.getConnection();
	
		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("select * from tb_order\n" +
				"inner join tb_order_product on tb_order.id = tb_order_product.order_id\n" +
				"inner join tb_product on tb_product.id = tb_order_product.product_id");

		Map<Long, Order> orders = new HashMap<>();

		while (rs.next()) {
			Long orderId = rs.getLong("order_id");
			Product product = instProduct(rs);
			Order order = orders.get(orderId);

			if (order == null) {
				order = instOrder(rs);
				orders.put(orderId, order);
			}

			if (!order.getProducts().contains(product)) {
				order.getProducts().add(product);
			}
		}

		for (Order order : orders.values()) {
			System.out.println("Pedido " + order.getId() + ":");
			System.out.println(order);
			for (Product product : order.getProducts()) {
				System.out.println(product);
			}
			System.out.println();
		}
	}

	private static Product instProduct(ResultSet resultSet) throws SQLException {
		Product product = new Product();

		product.setId(resultSet.getLong("product_id"));
		product.setName(resultSet.getString("name"));
		product.setPrice(resultSet.getDouble("price"));
		product.setDescription(resultSet.getString("description"));
		product.setImageUri(resultSet.getString("image_uri"));

		return product;
	}

	private static Order instOrder(ResultSet resultSet) throws SQLException {
		Order order = new Order();

		order.setId(resultSet.getLong("order_id"));
		order.setLatitude(resultSet.getDouble("latitude"));
		order.setLongitude(resultSet.getDouble("longitude"));
		order.setMoment(resultSet.getTimestamp("moment").toInstant());
		order.setStatus(OrderStatus.values()[resultSet.getInt("status")]);

		return order;
	}
}

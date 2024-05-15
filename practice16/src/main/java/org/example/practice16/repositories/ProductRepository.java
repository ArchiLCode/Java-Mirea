package org.example.practice16.repositories;

import lombok.AllArgsConstructor;
import org.example.practice16.entities.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ProductRepository {
    private final DataSource ds;

    public void init() throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS products (" +
                        "  id INT PRIMARY KEY," +
                        "  name VARCHAR(100) NOT NULL," +
                        "  price INT NOT NULL" +
                        ")"
        );
        ps.execute();
        PreparedStatement ps2 = connection.prepareStatement(
                "CREATE TABLE IF NOT EXISTS subjects (" +
                        "id INT PRIMARY KEY," +
                        "description VARCHAR(100) NOT NULL," +
                        "product_id INT," +
                        "FOREIGN KEY (product_id) REFERENCES products(id)" +
                        ")"
        );
        ps2.execute();
    }

    public List<Product> getProducts() throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from products");
        ResultSet rs = ps.executeQuery();
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            int price = rs.getInt(3);
            products.add(new Product(id, name, price));
        }
        return products;
    }

    public Product addProduct(Product product) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into products (id, name, price) values (?, ?, ?)", new String[] {"id"});
        ps.setInt(1, product.getId());
        ps.setString(2, product.getName());
        ps.setInt(3, product.getPrice());
        ps.executeUpdate();
        return product;
    }

    public boolean deleteProduct(int id) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("delete from products where id = ?");
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }
}


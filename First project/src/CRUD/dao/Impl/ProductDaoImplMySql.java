package CRUD.dao.Impl;

import CRUD.dao.ProductDao;
import CRUD.dao.dto.ProductDto;
import CRUD.entities.Product;

import CRUD.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplMySql implements ProductDao {

    private final Connection connection;

    public ProductDaoImplMySql() {
        this.connection = MySqlConnection.getDBConnection(); // Asegúrate de tener una clase MySqlConnection que proporcione la conexión a MySQL
    }

    @Override
    public void insert(ProductDto productDto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO product (name, price) VALUES (?, ?)");
            preparedStatement.setString(1, productDto.getName());
            preparedStatement.setDouble(2, productDto.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");

                Product newProduct = new Product(id, name, price);
                products.add(newProduct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void update(Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE product SET name=?, price=? WHERE id=?");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int productId) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM product WHERE id=?");
            preparedStatement.setInt(1, productId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Otros métodos según sea necesario

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

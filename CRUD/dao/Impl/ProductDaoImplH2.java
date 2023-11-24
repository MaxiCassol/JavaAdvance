package CRUD.dao.Impl;

import CRUD.dao.ProductDao;
import org.h2.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplH2 implements ProductDao {

    private final Connection connection;

    public ProductDaoImplH2(){
        this.connection = JdbcConnection.getDBConnection();
    }

    @Override
    public void insert(ProductDto productDto){
        try{
            Product newProduct = new Product();
            newProduct.setName(productDto.getName());
            newProduct.setPrice(productDto.getPrice());

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO product (name, price) VALUES (?, ?)");
            preparedStatement.setString(1, newProduct.getName());
            preparedStatement.setString(1, newProduct.getPrice());
            preparedStatement.executeUpdate();
            )
        }
    }

    @Override
    public List<Product> getAll(){
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM product");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Doble price = resultSet.getDouble("price");

                Product newProduct = new Product(id, name, price);
                products.add(newProduct);
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}

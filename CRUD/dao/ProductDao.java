package CRUD.dao;
import CRUD.dao.dto.ProductDto;
import CRUD.entities.Product;
import java.util.List;

public interface ProductDao {
    //CRUD

    //CREATE
    void insert(ProductDto productDto);

    //READ
    List<Product> getAll();

    //UPDATE
    void update(Product product);

    //DELETE
    void delete(int productId);
}

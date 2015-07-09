package lab04.repository;

import java.util.Collection;
import java.util.Map;

import lab04.model.Product;

public interface ProductRepository {
    public Product getProduct(long id);
    public long saveProduct(Product product);
    public Collection<Map.Entry<Long,Product>> getAllProduct();
}

package lab04;

import java.util.Collection;
import java.util.Map;

public interface ProductRepository {
    public Product getProduct(long id);
    public long saveProduct(Product product);
    public Collection<Map.Entry<Long,Product>> getAllProduct();
}

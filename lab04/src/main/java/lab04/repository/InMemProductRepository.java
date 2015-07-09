package lab04.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import lab04.model.Product;

public class InMemProductRepository implements ProductRepository {
    public static ProductRepository instance() {
        InMemProductRepository repository = new InMemProductRepository();
        repository.saveProduct(new Product("Le Petit Prince", 10L));
        repository.saveProduct(new Product("The last man standing", 12L));
        repository.saveProduct(new Product("Nothing matters", 100L));
        return repository;
    }

    private long listId = 0L;
    private Map<Long, Product> products = new HashMap<Long, Product>();

    private InMemProductRepository(){}

    @Override
    public Product getProduct(long id) {
        return products.getOrDefault(id, new Product("Unknown",0L));
    }

    @Override
    public long saveProduct(Product product) {
        products.put(++listId, product);
        return listId;
    }

    @Override
    public Collection<Map.Entry<Long, Product>> getAllProduct() {
        return products.entrySet();
    }

}

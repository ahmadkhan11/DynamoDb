package dynamodb.com.example.Dyname.db.service;

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import dynamodb.com.example.Dyname.db.entity.Product;
import dynamodb.com.example.Dyname.db.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  ProductRepository productRepository;

  @Override
  public List<Product> getProductList() {
    return (List<Product>) productRepository.findAll();
  }

  @Override
  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Product getProductById(String id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product Not Found :" + id));
  }

  @Override
  public Product updateProduct(String id, Product product) {
    productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"+id));
    product.setId(id);
    return productRepository.save(product);
  }

  @Override
  public void deleteProduct(String id) {
    productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product Not Found :"+id));
    productRepository.deleteById(id);
  }
}

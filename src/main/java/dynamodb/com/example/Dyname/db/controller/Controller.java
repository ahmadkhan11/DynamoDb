package dynamodb.com.example.Dyname.db.controller;


import dynamodb.com.example.Dyname.db.entity.Product;
import dynamodb.com.example.Dyname.db.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

  @Autowired
  ProductService productService;

  @PostMapping("/product")
  public ResponseEntity<Product> saveProduct(@RequestBody Product product){
    System.out.println("product = " + product);
    return ResponseEntity.ok(productService.saveProduct(product));
  }

  @GetMapping("/product/{id}")
  public ResponseEntity<Product> getProductById(@PathVariable String id){
    System.out.println("id = " + id);
    return ResponseEntity.ok(productService.getProductById(id));
  }

  @GetMapping("/products")
  public ResponseEntity<List<Product>> getProductList(){
    //System.out.println("productService = " + productService);
    return ResponseEntity.ok(productService.getProductList());
  }
  @PutMapping("/product/{id}")
  public ResponseEntity<Product> updateProduct(@PathVariable String id,@RequestBody Product product){
    System.out.println("id = " + id);
    return ResponseEntity.ok(productService.updateProduct(id,product));
  }
  @DeleteMapping("/product/{id}")
  public void deleteProductById(@PathVariable String id){
    productService.deleteProduct(id);
  }

}

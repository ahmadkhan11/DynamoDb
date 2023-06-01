package dynamodb.com.example.Dyname.db.repository;

import dynamodb.com.example.Dyname.db.entity.Product;
import java.awt.print.Pageable;
import java.util.List;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface ProductRepository extends CrudRepository<Product,String> {

//  @EnableScan
//    // Adjust the page and size values as per your requirements
//  List<Product> findAllWithPagination(Pageable pageable);

}

package ProductService.repository;


import ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    //namedquery

    Product findByPrice(double price);

}

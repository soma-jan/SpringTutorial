package ProductService.controller;

import ProductService.Exception.ProductNotFoundException;
import ProductService.model.Product;
import ProductService.service.IProductService;
import ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    @Qualifier("demoProductService")
    IProductService prod;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts()
    {
        List<Product> productlist =prod.getAllProducts();
        return ResponseEntity.accepted().body(productlist);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) throws ProductNotFoundException {
     Product product=prod.getProductById(id);
     return ResponseEntity.accepted().body(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody  Product newProduct)
    {
        Product product= prod.addProduct(newProduct);
        return ResponseEntity.accepted().body(product);

    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product upProduct,@PathVariable int id) throws ProductNotFoundException {
        Product product = prod.updateProduct(upProduct,id);
        return ResponseEntity.accepted().body(product);
    }



    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) throws ProductNotFoundException {
      boolean b=  prod.delete(id);
      String response="";
      if(b==true)
      {
          response ="deleted successfully!" ;
      }
        return ResponseEntity.accepted().body(response);

    }




}

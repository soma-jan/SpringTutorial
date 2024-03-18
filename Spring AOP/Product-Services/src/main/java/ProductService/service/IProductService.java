package ProductService.service;

import ProductService.Exception.ProductNotFoundException;
import ProductService.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    public List<Product> getAllProducts();
    public Product getProductById(int id ) throws ProductNotFoundException;
    public boolean delete(int id) throws ProductNotFoundException;
    public Product updateProduct( Product upProduct,int id) throws ProductNotFoundException;
    public Product addProduct(Product  newProduct);
    public Product findProductByPrice(double price);
}

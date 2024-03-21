package ProductService.service;

import ProductService.Exception.ProductNotFoundException;
import ProductService.aop.LogExecutionTime;
import ProductService.model.Product;
import ProductService.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class ProductService implements IProductService {
    @Autowired
    ProductRepo productrepo;
    @LogExecutionTime
    @Cacheable(value="products")
    public List<Product> getAllProducts()
    {
        return productrepo.findAll();
    }
    @LogExecutionTime
    @Cacheable(value="products",key = "#id")
    public Product getProductById(int id ) throws ProductNotFoundException
    {
        return productrepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product","id",id));

    }
    @LogExecutionTime
    @CacheEvict(value = "products", allEntries = true )
    @CachePut(value = "products", key = "#id")
    public boolean delete(int id) throws ProductNotFoundException {
        Product product=productrepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product","id",id));
        productrepo.delete(product);
        return true;
    }
    @LogExecutionTime
    @CacheEvict(value = "products", allEntries = true )
    @CachePut(value = "products", key = "#id")
    public Product updateProduct( Product upProduct,int id) throws ProductNotFoundException {
        Product product=productrepo.findById(id).orElseThrow(()->new ProductNotFoundException("Product","id",id));
        product.setCategory(upProduct.getCategory());
        product.setCode(upProduct.getCode());
        product.setImage(upProduct.getImage());
        product.setDescription(upProduct.getDescription());
        product.setName(upProduct.getName());
        product.setPrice(upProduct.getPrice());
        product.setInventorystatus(upProduct.getInventorystatus());
        System.out.println(upProduct.getInventorystatus());
        product.setQuantity(upProduct.getQuantity());
        product.setRating(upProduct.getRating());
        return productrepo.save(product);

    }
    @LogExecutionTime
    @CachePut(value = "products",key ="#newProduct.id")
    public Product addProduct(Product  newProduct)
    {

        return productrepo.save(newProduct);
    }

    public Product findProductByPrice(double price)
    {
        return productrepo.findByPrice(price);
    }
}

package ProductService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "product")
@Data
@NamedQuery(name = "Product.findByPrice",
        query = "select p from Product  p where p.price =?1")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
    private String description;
    private String image;
    private double price;
    private String category;
    private int quantity;
    @Enumerated(EnumType.STRING)
    @Column(name = "inventoryStatus")
    private InventoryStatus inventorystatus;
    private int rating;
}

package lesson7;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "id")
private int productId;

    @Column(unique =true, nullable = false)
private  String name;
    @Column(nullable = false)
private double price;
    @Column
private String country;

}

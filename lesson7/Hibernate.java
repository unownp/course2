package lesson7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Hibernate {
    public static void main(String[] args) {
        Configuration configuration= new Configuration().configure();
        //StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder()builder.applySettings(configuration.getProperties()).build());;
        SessionFactory factory=configuration.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tr =session.beginTransaction();

        List<Product> products = session
                .createQuery("from Product", Product.class).getResultList();



        for (Product product : products){
            System.out.println(product.toString());
        }
        tr.commit();
                factory.close();
    }
}

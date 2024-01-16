package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Product;

public class App {
	static int id = 4;

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Transaction tx = null;

        // Create session
        Session session = factory.openSession();
        //entity
        
        Product product = new Product();
        product.setpId(id);
        product.setpName("RTX 4060");
        product.setPrice(140000);
        product.setSrs("5000");
        product.setStock(5);
//        session.save(product);
        
        try {
        	
        	tx = session.beginTransaction();
        	session.save(product);
        	tx.commit();
        }catch(HibernateException e) {
        	e.toString();
        }finally {
        	session.close();
        	factory.close();
        	id++;
        }
    }
}

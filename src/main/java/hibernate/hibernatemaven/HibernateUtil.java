/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.hibernatemaven;

import java.io.File;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author 3amerjr
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {

         //       Configuration configuration = new Configuration().configure(new File("src/main/resources/hibernate.cfg.xml"));
          //      Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties

  //              Properties settings = new Properties();
                
//
//                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//
//                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/maven?zeroDateTimeBehavior=convertToNull");
//
//                settings.put(Environment.USER, "root");
//
//                settings.put(Environment.PASS, "159357mohamed");
//
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
//
//                settings.put(Environment.SHOW_SQL, "true");
//
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//
//                settings.put(Environment.HBM2DDL_AUTO, "validate");
//               

  //              configuration.setProperties(settings);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure(new File("src/main/java/hibernate.cfg.xml")).build();

//                sessionFactory = configuration.//addAnnotatedClass(Person.class).
//                        buildSessionFactory(serviceRegistry);
                sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return sessionFactory;

    }
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure(new File("src/main/java/hibernate.cfg.xml")) // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//        } catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
//            // so destroy it manually.
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//        return sessionFactory;
//    }
}

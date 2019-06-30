/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.hibernatemaven;

import model.Person;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author 3amerjr
 */
public class Main {

    public static void main(String[] args) {
        final Logger logger = Logger.getLogger(Main.class);
        Session session = null;

        try {
            logger.info(
                    "\n------------------------------------------------------------------------------------------------------------------------------------------------------");

            logger.info("Inside Try");

            session = HibernateUtil.getSessionFactory().openSession();

            System.out.println(session.toString());

            session.getTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();

            CriteriaQuery<Person> cq = cb.createQuery(Person.class);

            Root<Person> root = cq.from(Person.class);
            cq.orderBy(cb.desc(root.get("id")));
            List<Person> results = session.createQuery(cq).getResultList();

            for (Person x : results) {
                System.out.println(x.getName());
            }
        } catch (HibernateException e) {
            logger.error("Errored Occured " + e.toString());
        } finally {
            session.close();
            logger.info("Current Session Closed");
            HibernateUtil.getSessionFactory().close();
            System.out.println(HibernateUtil.getSessionFactory().isClosed());
            logger.info("Session Factory Closed");
            logger.info(
                    "\n------------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }
}

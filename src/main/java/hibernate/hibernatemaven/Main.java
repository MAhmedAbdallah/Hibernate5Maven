/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.hibernatemaven;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author 3amerjr
 */
public class Main {

    public static void main(String[] args) {
        final  Logger logger = Logger.getLogger(Main.class);
        

        try {
             logger.info(
                     
       "\n/------------------------------------------------------------------------------------------------------------------------------------------------------/");
             
            logger.info("Inside Try");
            System.out.println(HibernateUtil.getSessionFactory().openSession().toString());
            System.out.println(HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction().isActive());
        } catch (HibernateException e) {
          logger.error( "Errored Occured "+ e.toString());
        } finally {
            HibernateUtil.getSessionFactory().getCurrentSession().close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

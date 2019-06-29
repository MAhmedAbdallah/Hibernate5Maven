/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate.hibernatemaven;

import org.hibernate.HibernateException;

/**
 *
 * @author 3amerjr
 */
public class Main {
    public static void main(String[] args) {
        try{
        System.out.println(HibernateUtil.getSessionFactory().openSession().toString());
        System.out.println(HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction().isActive());
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
        finally{
             HibernateUtil.getSessionFactory().getCurrentSession().close();
            HibernateUtil.getSessionFactory().close();
        }
    }
}

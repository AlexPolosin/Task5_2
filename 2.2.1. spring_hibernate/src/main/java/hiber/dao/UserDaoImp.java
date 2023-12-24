package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      List<User> list = sessionFactory.getCurrentSession().createQuery("from User").getResultList();
//      TypedQuery<User> query= sessionFactory.getCurrentSession().createQuery("from User");
      return list;
   }

   @Override
   public List<User> getUserByCar(String model, int series) {
      List<User> list = sessionFactory.getCurrentSession().
              createQuery("from User user  WHERE user.car.model = :model and user.car.series = :series")
              .setParameter("model", model).setParameter("series", series).getResultList();
      return list;
   }

}

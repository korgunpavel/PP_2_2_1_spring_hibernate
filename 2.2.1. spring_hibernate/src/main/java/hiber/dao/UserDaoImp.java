package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user, Car car) {
      sessionFactory.getCurrentSession().save(user);
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery(
              "SELECT u FROM User u JOIN FETCH u.car");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getByCar(int series, String model) {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                      "SELECT u FROM User u JOIN FETCH u.car WHERE Car.series = :series AND Car.model = :model")
              .setParameter("series", series)
              .setParameter("model", model);
      return query.getSingleResult();
   }

}

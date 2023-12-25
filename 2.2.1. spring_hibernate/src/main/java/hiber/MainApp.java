package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car car = new Car("Audi", 5);
      Car car1 = new Car("Audi", 4);
      Car car2 = new Car("Audi", 3);
      Car car3 = new Car("Audi", 4);
      user1.setCar(car);
      user2.setCar(car1);
      user3.setCar(car2);
      user4.setCar(car3);
      userService.addUser(user1);
      userService.addUser(user2);
      userService.addUser(user3);
      userService.addUser(user4);

      List<User> users = userService.getListUsers();
      for (User user : users) {
         System.out.println(user);
      }

      List<User> usersWithCar = userService.getUserByCar("Audi", 4);
      for (User user : usersWithCar) {
         System.out.println(user);
      }
   }
}

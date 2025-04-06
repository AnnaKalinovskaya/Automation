import Task1.EntityManager;
import Task1.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Task1Tests {

    private final EntityManager manager = new EntityManager();

    public static Stream<Arguments> randomValidUsers(){

        List<User> list1 = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list1.add(new User("Name" + i, new Random().nextInt(18, 100), "Name" + i + "@mail.ru", "active"));
        }

        List<User> list2 = new ArrayList<>();
        for (int i = 11; i <= 20; i++) {
            list2.add(new User("Name" + i, new Random().nextInt(18, 100), "Name" + i + "@mail.ru", "blocked"));
        }

        List<User> list3 = new ArrayList<>();
        for (int i = 21; i <= 30; i++) {
            list3.add(new User("Name" + i, new Random().nextInt(18, 100), "Name" + i + "@mail.ru", "offline"));
        }

        return Stream.of(Arguments.of(list1, list2, list3));
    }


    @ParameterizedTest
    @MethodSource("randomValidUsers")
    public void addMultipleUsers(List<User> list1, List<User> list2, List<User> list3) throws InterruptedException {
        int totalUsersToAdd = list1.size() + list2.size() + list3.size();

        Thread t1 = new Thread(() -> {
                for (User user : list1) {manager.addUser(user);}
            });
        Thread t2 = new Thread(() -> {
            for (User user : list2) {manager.addUser(user);}
        });
        Thread t3 = new Thread(() -> {
            for (User user : list3) {manager.addUser(user);}
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        Assertions.assertEquals(totalUsersToAdd, manager.getUsersList().size(), "Not all users were added");
    }

    @Test
    public void testFilters(){
        List<User> list = manager.getUsersList();
        List<User> filteredByAge = manager.filterByAge(90, 100);
        int expectedNumber = list.stream().filter(u -> u.getAge() >= 90 && u.getAge() <= 100).toList().size();
        Assertions.assertEquals(expectedNumber, filteredByAge.size(), "Wrong number of users were filtered by age");

        List<User> filteredByName = manager.filterByName("Name1");
        int expectedNumber2 = list.stream().filter(u -> u.getName().toLowerCase().equals("Name1".toLowerCase())).toList().size();
        Assertions.assertEquals(expectedNumber2, filteredByName.size(), "Wrong number of users were filtered by name");


        List<User> filteredByStatus = manager.filterByStatus("offline");
        int expectedNumber3 = list.stream().filter(u -> u.getStatus().toLowerCase().equals("offline".toLowerCase())).toList().size();
        Assertions.assertEquals(expectedNumber3, filteredByStatus.size(), "Wrong number of users were filtered by status");
    }

    @ParameterizedTest
    @MethodSource("randomValidUsers")
    public void removeUsers(List<User> list1, List<User> list2) throws InterruptedException {
        Thread t1 = new Thread( () -> {
            for (User u: list1) {
                manager.removeUser(u);
            }
        });

        Thread t2 = new Thread( () -> {
            for (User u: list2) {
                manager.removeUser(u);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        Assertions.assertFalse(manager.getUsersList().containsAll(list1) && manager.getUsersList().containsAll(list2),
                "Not all users were removed");
    }

}

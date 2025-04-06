package Task1;

import java.util.ArrayList;
import java.util.List;

public class EntityManager <T extends User> {

    private volatile List<T> users = new ArrayList<T>();

    public synchronized void addUser(T user){
        this.users.add(user);
    }

    public synchronized boolean removeUser(T user){
        return this.users.remove(user);
    }

    public synchronized List<T> getUsersList(){
        return this.users;
    }

    public List<T> filterByAge(int fromAge, int toAge){
        if (fromAge > toAge) {throw new IllegalArgumentException ("Invalid age bound");}
        return this.users.stream().filter(user -> user.getAge() >= fromAge && user.getAge() <= toAge).toList();
    }

    public List<T> filterByName(String name){
        return this.users.stream().filter(user -> user.getName().toLowerCase().equals(name.toLowerCase())).toList();
    }

    public List<T> filterByStatus(String status){
        return this.users.stream().filter(user -> user.getStatus().toLowerCase().equals(status.toLowerCase())).toList();
    }

}

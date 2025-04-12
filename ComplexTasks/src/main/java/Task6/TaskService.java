package Task6;

import java.util.*;

public class TaskService <T>{

    private Set<Task<T>> allTasks = new HashSet<>();

    public Set<Task<T>> getAllTasks(){
        return this.allTasks;
    }

    public void addNewTask(Task t){
        this.allTasks.add(t);
    }

    public synchronized void deleteTask(T id){
        Task<T> taskToDelete = this.allTasks.stream().filter(t -> t.getId() == id).findFirst().get();
        allTasks.remove(taskToDelete);
    }

    public List<Task<T>> filterByStatus (String status){
        return allTasks.stream().filter(t -> t.getStatus().equals(status)).toList();
    }

    public List<Task<T>> filterByPriority (String priority){
        return allTasks.stream().filter(t -> t.getPriority().equals(priority)).toList();
    }

    public ArrayList<Task<T>> sortedByDate(){
        ArrayList<Task<T>> sorted = new ArrayList<>(allTasks.stream().toList());
        sorted.sort(new TaskComparator());
        return sorted;
    }


}

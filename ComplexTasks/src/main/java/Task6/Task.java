package Task6;

import java.time.LocalDate;
import java.util.Objects;

public class Task <T>{

    private T id;
    private String status;
    private String priority;
    private LocalDate date;

    public Task(T id, String status, String priority, LocalDate date){
        this.id = id;
        this.status = status.toLowerCase();
        this.priority = priority.toLowerCase();
        this.date = date;
    }

    public T getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task<?> task = (Task<?>) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString(){
        return this.id.toString();
    }
}

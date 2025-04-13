import Task6.Task;
import Task6.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Task6Tests {

    private static TaskService ts = new TaskService();

    @BeforeAll
    public static void testDataPrep(){
        Task<String> t1 = new Task("12324", "active", "high", LocalDate.of(2025, 1, 1));
        Task<String> t2 = new Task("435", "on hold", "medium", LocalDate.of(2025, 6, 21));
        Task<String> t3 = new Task("23443", "blocked", "high", LocalDate.of(2025, 3, 15));
        Task<String> t4 = new Task("67567", "active", "medium", LocalDate.of(2025, 8, 7));
        Task<String> t5 = new Task("3767", "in process", "low", LocalDate.of(2025, 12, 4));
        Task<String> t6 = new Task("155", "active", "high", LocalDate.of(2025, 3, 23));

        ts.addNewTask(t1);
        ts.addNewTask(t2);
        ts.addNewTask(t3);
        ts.addNewTask(t4);
        ts.addNewTask(t5);
        ts.addNewTask(t6);
    }

    public static Stream<Arguments> validTaskToAdd(){
        return Stream.of(
                Arguments.of(new Task<>("333", "active", "high", LocalDate.of(2025, 1, 1))),
                Arguments.of(new Task<>("222", "active", "high", LocalDate.of(2025, 1, 1)))
        );
    }

    public static Stream<Arguments> validTaskToDelete(){
        return Stream.of(
                Arguments.of("000"),
                Arguments.of("00000")
        );
    }

    @ParameterizedTest
    @MethodSource("validTaskToAdd")
    public void addTask(Task<?> t){
        ts.addNewTask(t);
        Assertions.assertTrue(ts.getAllTasks().contains(t), "Task wasn't added: " + t);
    }

    @ParameterizedTest
    @MethodSource("validTaskToAdd")
    public void deleteTask(Task<?> t){
        ts.deleteTask(t.getId());
        Assertions.assertFalse(ts.getAllTasks().contains(t), "Task wasn't deleted: " + t);
    }

    @Test
    public void testFilterByStatus(){
        List<Task<?>> filtered = ts.filterByStatus("active");
        Assertions.assertTrue(filtered.stream().allMatch(t -> t.getStatus().equals("active")), "Not all filtered tasks have same status");
    }

    @Test
    public void testFilterByPriority(){
        List<Task<?>> filtered = ts.filterByPriority("high");
        Assertions.assertTrue(filtered.stream().allMatch(t -> t.getPriority().equals("high")), "Not all filtered tasks have same priority");
    }
}

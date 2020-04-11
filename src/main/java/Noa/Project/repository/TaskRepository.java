//package Noa.Project.repository;
//
//import Noa.Project.domain.Task;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.Month;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class TaskRepository {
//    private Map<Integer, Task> map;
//
//    public TaskRepository(){
//        map = new HashMap<>();
//        LocalDate date = LocalDate.of(2020, Month.MARCH, 20);
//        LocalDate date1 = LocalDate.of(2020, Month.MARCH, 21);
//        LocalDate date2 = LocalDate.of(2020, Month.MARCH, 27);
//        LocalTime time = LocalTime.of(10, 0);
//        LocalTime time1 = LocalTime.of(15, 0);
//        LocalTime time2 = LocalTime.of(17, 0);
//        map.put(1, new Task(1, "Task 1", "Lorem", date, time ));
//        map.put(2, new Task(2,"Task 2", "Lorem", date1, time1));
//        map.put(3, new Task(3,"Task 3","Lorem",  date2, time2));
//    }
//
//    public Map<Integer, Task> getMap() {
//        return map;
//    }
//
//    public void addTask(Task task)
//    {
//        map.put(task.getId(), task);
//    }
//}

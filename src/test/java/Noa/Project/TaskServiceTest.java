package Noa.Project;
import Noa.Project.domain.SubTask;
import Noa.Project.domain.Task;
import Noa.Project.dto.SubTaskDTO;
import Noa.Project.dto.TaskDTO;
import Noa.Project.service.TaskService;
import Noa.Project.service.TaskServicelmpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    @Test
    @Order(1)
    public void testGetTasks()
    {
        //setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("jeff");
        taskDTO.setDescription("Dunham");
        taskDTO.setDate(LocalDateTime.of(2020, 03, 10, 10, 0));
        taskService.addTask(taskDTO);

        //method to be tested
        Map<Long, Task> tasks = taskService.getTasks();

        //checks
        assertNotNull(tasks);
        assertFalse(tasks.isEmpty());
        assertEquals(1, tasks.size());
        assertNotNull(tasks.get(1L));
    }

    @Test
    @Order(2)
    public void testAddSubTask()
    {
        //setup
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("jeff2");
        taskDTO.setDescription("Dunham2");
        taskDTO.setDate(LocalDateTime.of(2020, 03, 10, 10, 0));
        taskService.addTask(taskDTO);

        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("Noa");
        subTaskDTO.setDescription("COOL");

        taskService.addSubtask(2L, subTaskDTO);
        Task task = taskService.getTasks().get(2L);

        //checks
        assertNotNull(task.getSubTasks());
        assertFalse(task.getSubTasks().isEmpty());
        assertEquals(1, task.getSubTasks().size());
        assertNotNull(task.getSubTasks().get(0));

    }

    @Test
    @Order(3)
    public void testEditTask()
    {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setTitle("jeff3");
        taskDTO.setDescription("Dunham3");
        taskDTO.setDate(LocalDateTime.of(2020, 03, 10, 10, 0));
        taskService.addTask(taskDTO);

        TaskDTO taskDTO2 = new TaskDTO();
        taskDTO2.setTitle("jaff");
        taskDTO2.setDescription("Dunham");
        taskDTO2.setDate(LocalDateTime.of(2020, 03, 10, 10, 0));
        taskService.editTask(3L, taskDTO2);

        //method to be tested
        Task task = taskService.getTasks().get(3L);

        //checks
        assertNotNull(task);
        assertEquals(task.getTitle(), "jaff");
        assertEquals(task.getDescription(), "Dunham");
    }

}

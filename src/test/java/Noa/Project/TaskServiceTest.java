package Noa.Project;
import Noa.Project.domain.SubTask;
import Noa.Project.domain.Task;
import Noa.Project.dto.SubTaskDTO;
import Noa.Project.dto.TaskDTO;
import Noa.Project.service.TaskService;
import Noa.Project.service.TaskServicelmpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;

    @Test
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
    public void testAddSubTask()
    {
        //setup
        SubTaskDTO subTaskDTO = new SubTaskDTO();
        subTaskDTO.setTitle("Noa");
        subTaskDTO.setDescription("COOL");

        taskService.addSubtask(1L, subTaskDTO);
        Task task = taskService.getTasks().get(1L);

        //checks
        assertNotNull(task.getSubTasks());
        System.out.println(task.getSubTasks());
        System.out.println(taskService.getTasks().keySet());
        assertFalse(task.getSubTasks().isEmpty());
        assertEquals(1, task.getSubTasks().size());
        assertNotNull(task.getSubTasks().get(0));

    }

}

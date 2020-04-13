package Noa.Project.controller;

import Noa.Project.domain.SubTask;
import Noa.Project.domain.Task;
import Noa.Project.dto.SubTaskDTO;
import Noa.Project.dto.TaskDTO;
import Noa.Project.service.TaskService;
import Noa.Project.service.TaskServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class TasksController {
    private final TaskService taskService;
    @Autowired
    public TasksController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @GetMapping
    public String getindex()
    {
        return "index";
    }
    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String getTasks(Model model){
        if (taskService.getTasks().size() == 0)
        {
            model.addAttribute("notasks", true);
        }else {
            model.addAttribute("notasks", false);
            model.addAttribute("tasks", taskService.getTasks().values());
        }

        return "tasks";
    }

    //navigatie naar details + ophalen van id
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public String getTaskinfo(@PathVariable("id") Long id, Model model)
    {
        if (taskService.getTasks().get(id) == null)
        {
            model.addAttribute("notask", true);
        }else {
            model.addAttribute("notask", false);
            model.addAttribute("title", taskService.getTasks().get(id).getTitle());
            model.addAttribute("description", taskService.getTasks().get(id).getDescription());
            model.addAttribute("duedate", taskService.getTasks().get(id).getdatedetail());
            model.addAttribute("taskid", id);
            if (!taskService.getTasks().get(id).noSubtasks())
            {
                model.addAttribute("subtasks", taskService.getTasks().get(id).getSubTasks());
            }
        }

        return "task";
    }
    @RequestMapping(value = "/tasks/edit/{id}", method = RequestMethod.GET)
    public String editdetails(@PathVariable("id") Long id, Model model)
    {
        if (taskService.getTasks().get(id) == null)
        {
            model.addAttribute("notexist", true);
        }else {
            model.addAttribute("notexist", false);
            model.addAttribute("editId", id);
            model.addAttribute("editTitle", taskService.getTasks().get(id).getTitle());
            model.addAttribute("editDescription", taskService.getTasks().get(id).getDescription());
            model.addAttribute("editDate", taskService.getTasks().get(id).getDate());
        }

        return "edit";
    }
    //navigatie naar new
    @GetMapping("/tasks/new")
    public String getnew(Model model)
    {
        model.addAttribute("taskdto", new TaskDTO());
        return "new";
    }

    //create subtask nav
    @RequestMapping(value = "/tasks/{id}/sub/create", method = RequestMethod.GET)
    public String newSubTask(@PathVariable("id") Long id, Model model)
    {
        if (taskService.getTasks().get(id) == null)
        {
            model.addAttribute("notexist", true);
        }else {
            model.addAttribute("notexist", false);
            model.addAttribute("subId", id);
        }

        return "create";

    }


    @RequestMapping(value = "/tasks/edited/{id}")
    public String editTask(@PathVariable("id") Long id, @ModelAttribute TaskDTO task )
    {
        taskService.editTask(id, task);
        return "redirect:/tasks/" + id;
    }

    @RequestMapping(value = "/tasks/subbed/{id}")
    public String editTask(@PathVariable("id") Long id, @ModelAttribute SubTaskDTO task )
    {
        taskService.addSubtask(id, task);
        return "redirect:/tasks/" + id;
    }


    @PostMapping
    public String addTask(@ModelAttribute("taskdto") @Valid TaskDTO taskdto, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "new";
        }else
        {
            taskService.addTask(taskdto);
            return "redirect:/tasks";
        }

    }
}

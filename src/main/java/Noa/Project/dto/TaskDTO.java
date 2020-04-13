package Noa.Project.dto;

import Noa.Project.domain.SubTask;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {
    @NotEmpty
    @Size(min=2)
    private String title, description;
    private LocalDateTime date;
//    private List<SubTask> list = new ArrayList<>();
    public LocalDateTime getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

//    public List<SubTask> getList() {
//        return list;
//    }
//    public void addSubTask(SubTask subTask)
//    {
//        list.add(subTask);
//    }

    public String getDescription() {
        return description;
    }
}


package Noa.Project.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
    @SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
    private Long id;
    @NotEmpty
    private String title, description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime date;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SubTask> list = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDuedate() {

        return toString();
    }
    public String getdatedetail()
    {
        DateTimeFormatter formatdate = DateTimeFormatter.ofPattern("MMMM d u");
        DateTimeFormatter formattime = DateTimeFormatter.ofPattern("h a");
        return date.format(formatdate) + " at " + date.format(formattime);
    }

    public String getDescription() {
        return description;
    }

    public void addSubTask(SubTask subTask)
    {
        list.add(subTask);
    }
    public boolean noSubtasks()
    {
        return list.size() == 0;
    }

    public String toString()
    {

        return "• " + title + ": due " + getdatedetail();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<SubTask> getSubTasks() {
        return list;
    }
}

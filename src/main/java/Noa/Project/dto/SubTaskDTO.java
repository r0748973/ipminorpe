package Noa.Project.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class SubTaskDTO {
    @NotEmpty
    @Size(min = 3)
    private String description, title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

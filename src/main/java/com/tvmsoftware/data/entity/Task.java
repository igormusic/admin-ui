package com.tvmsoftware.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
public class Task extends AbstractEntity{

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private Integer priority;
    private String assignee;
}

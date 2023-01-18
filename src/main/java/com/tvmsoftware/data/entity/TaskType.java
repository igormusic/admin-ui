package com.tvmsoftware.data.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class TaskType extends AbstractEntity{

    private String name;
    private String description;

}

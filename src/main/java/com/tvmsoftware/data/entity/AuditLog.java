package com.tvmsoftware.data.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class AuditLog extends AbstractEntity {

    @Column(nullable = false)
    private String entityName;
    @Column(nullable = false)
    private Long entityId;
    @Column(nullable = false)
    private String action;
    private String username;
    @Column(length = 1000)
    private String description;

}

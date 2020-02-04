package ru.nspk.testAutomation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BALANCER_ENTITIES")
public class HostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "host")
    private String host;

    @Column(name = "database_schema")
    private String schema;

    @Column(name = "in_progress")
    private boolean inProgress;

}

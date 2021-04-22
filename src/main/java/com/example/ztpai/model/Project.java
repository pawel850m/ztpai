package com.example.ztpai.model;

import com.example.ztpai.project.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,
            nullable = false
    )
    private Long projectId;
    @NotBlank(message = "Project name cannot be empty!")
    private String name;
    @NotBlank(message = "Project description cannot be empty!")
    @Lob
    @Column(name="description", length=512)
    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Status status;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ticket> tickets;

}

package com.example.ztpai.model;

import com.example.ztpai.ticket.TicketPriority;
import com.example.ztpai.ticket.TicketStatus;
import com.example.ztpai.ticket.TicketType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,
            nullable = false
    )
    private Long ticketId;

    @NotBlank(message = "Ticket title cannot be empty!")
    private String title;

    @NotBlank(message = "Ticket description cannot be empty!")
    @Lob
    @Column(name="description", length=512)

    private String description;
    @Column(updatable = false,
            nullable = false
    )

    private LocalDateTime created_at;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)

    private TicketStatus status;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)

    private TicketPriority priority;
    @Enumerated(EnumType.STRING)
    @Column(length = 30)

    private TicketType type;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_tickets",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userSet = new ArrayList<>();
}

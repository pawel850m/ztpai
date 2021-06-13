package com.example.ztpai.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,
            nullable = false
    )
    private Long UserId;

    @Column(
            nullable = false
    )
    @NotBlank
    private String firstName;

    @Column(
            nullable = false
    )
    @NotBlank
    private String lastName;

    @Email
    @Column(
            nullable = false
    )
    private String email;
    private Boolean enabled;

    @Column(
            nullable = false
    )
    private LocalDateTime created_at;

    @Column(
            nullable = false
    )
    @NotBlank
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VerificationToken verificationToken;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL, CascadeType.REFRESH}, mappedBy = "userSet")
    private List<Ticket> ticketList = new ArrayList<>();

}

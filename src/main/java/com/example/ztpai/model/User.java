package com.example.ztpai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name = "users")
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}

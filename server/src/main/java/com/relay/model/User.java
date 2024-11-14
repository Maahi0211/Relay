package com.relay.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.annotation.processing.Generated;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String avatarUrl;
    private String status;

    @OneToMany(mappedBy = "owner")
    private Set<Server> ownedServers = new HashSet<>();

    @OneToMany(mappedBy="user")
    private Set<UserRole> userRoles=new HashSet<>();

    @OneToMany(mappedBy="user")
    private Set<Friend> friends = new HashSet<>();
}
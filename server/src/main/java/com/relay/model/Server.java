package com.relay.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.annotation.processing.Generated;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="servers")
public class Server{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long serverId;
    private String name;
    private String description;
    private String iconUrl;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="owner_id", nullable=false)
    private User owner;

    @OneToMany(mappedBy="server")
    private Set<Channel> channels = new HashSet<>();

    @OneToMany(mappedBy="server")
    private Set<Role> roles=new HashSet<>();
}
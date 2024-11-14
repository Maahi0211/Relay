package com.relay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="channels")
public class Channel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long channelId;
    private String name;
    private String typr;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="server_id", nullable=false)
    private Server server;

    @OneToMany(mappedBy = "channel")
    private Set<Message> messages=new HashSet<>();

    @OneToMany(mappedBy = "channel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ChannelRolePermission> channelRolePermissions=new HashSet<>();
}

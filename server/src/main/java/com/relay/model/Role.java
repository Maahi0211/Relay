package com.relay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roleId;
    private String name;
    private String color;

    @ManyToOne
    @JoinColumn(name = "server_id", nullable=false)
    private Server server;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles=new HashSet<>();

    @OneToMany(mappedBy = "role")
    private  Set<ChannelRolePermission> channelRolePermissions=new HashSet<>();
}

package com.relay.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "channel_role_permissions")
public class ChannelRolePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Reference to the Channel entity
    @ManyToOne
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    // Reference to the Role entity
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    // Reference to the Permission entity
    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)  // Correct column name
    private Permission permission;
}

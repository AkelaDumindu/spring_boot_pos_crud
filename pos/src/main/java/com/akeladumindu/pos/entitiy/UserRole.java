package com.akeladumindu.pos.entitiy;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_role")
public class UserRole {

    @Id
    @Column(name = "role_id", length = 45)
    private String roleId;

    @Column(name = "role_name", length = 45)
    private String roleName;

    @Column(name = "role_description", length = 250)
    private String roleDescription;

    @OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY)
    private Set<UserRoleHasUser> userRoleHasUsers;

}

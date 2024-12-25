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
public class User {

    @Id
    @Column(name = "user_id", length = 45)
    private String userId;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "full_name", length = 250)
    private String fullName;

    @Column(name = "password", length = 750)
    private String password;

    @Column(name = "is_account_non_expired", columnDefinition = "TINYINT")
    private String isAccountNonExpired;

    @Column(name = "is_account_non_locked", columnDefinition = "TINYINT")
    private String isAccountNonLocked;

    @Column(name = "is_credentials_non_expired", columnDefinition = "TINYINT")
    private String isCredentialsNonExpired;

    @Column(name = "is_enabled", columnDefinition = "TINYINT")
    private String isEnabled;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserRoleHasUser> userRoleHasUsers;
}

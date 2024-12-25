package com.akeladumindu.pos.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserRoleHasUserKey implements Serializable {

    @Column(length = 45, name = "user_id")
    private String userId;

    @Column(length = 45, name = "role_id")
    private String UserRoleId;
}

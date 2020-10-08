package com.fedolab.dropshipping.components.user.model;

import com.fedolab.dropshipping.components.common.repository.Auditable;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User extends Auditable {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "failedattempts")
    private int failedAttempts;
}

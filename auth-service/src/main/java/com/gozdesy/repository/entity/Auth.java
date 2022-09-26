package com.gozdesy.repository.entity;

import com.gozdesy.repository.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "auths")
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auth {

    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    Long id;
    String username;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;

}

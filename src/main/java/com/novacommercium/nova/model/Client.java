package com.novacommercium.nova.model;


import com.novacommercium.nova.security.GeneralRole;
import com.novacommercium.nova.security.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Client {

    @Id
    private int id;

    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_client",
    joinColumns = @JoinColumn( name = "id_client"),
    inverseJoinColumns =@JoinColumn(name = "id_role"))
    private Collection<Role> roles;

    private void add(Role role){
        if(this.roles == null){
            roles = new ArrayList<>();
        }

        roles.add(role);
    }
}

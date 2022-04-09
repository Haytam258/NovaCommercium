package com.novacommercium.nova.services;

import com.novacommercium.nova.model.Client;
import com.novacommercium.nova.repositories.ClientRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class MyUserDetailsService implements UserDetailsService {


    private final ClientRepoInterface clientRepoInterface;

    @Autowired
    public MyUserDetailsService(ClientRepoInterface clientRepoInterface) {
        this.clientRepoInterface = clientRepoInterface;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Client client = clientRepoInterface.findClientByUsername(username);
        //On va attribuer une authorité selon ce que le client a dans la base de données (on a mis client "testing" est ADMIN)
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //On prend les roles de la base de données, et pour chaque role on lui attribue une authorité qu'on va controler après dans les controllers
        client.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoles().getRole()));
        });
        return new User(client.getUsername(), client.getPassword(), authorities);
    }
}

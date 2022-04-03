package com.novacommercium.nova.services;

import com.novacommercium.nova.model.Client;
import com.novacommercium.nova.repositories.ClientRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        return new User(client.getUsername(), client.getPassword(), new ArrayList<>());
    }
}

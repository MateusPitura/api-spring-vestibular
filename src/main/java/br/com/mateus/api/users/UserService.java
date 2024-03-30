package br.com.mateus.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    @Autowired
    private RepositoryUsers repositoryUsers;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return repositoryUsers.findByUsername(username);
    }
}

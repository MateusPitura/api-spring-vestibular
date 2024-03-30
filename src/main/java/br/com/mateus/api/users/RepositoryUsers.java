package br.com.mateus.api.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface RepositoryUsers extends JpaRepository<Users, Long> {
    UserDetails findByUsername(String username);
}

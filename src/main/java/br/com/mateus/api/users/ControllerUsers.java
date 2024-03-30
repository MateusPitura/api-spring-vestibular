package br.com.mateus.api.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.mateus.api.security.TokenDTO;
import br.com.mateus.api.security.TokenService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/login")
public class ControllerUsers {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Transactional
    public ResponseEntity<TokenDTO> validateUser(@RequestBody UserDTO dto){
        Authentication userCredentials = new UsernamePasswordAuthenticationToken(dto.username(), dto.password());
        Authentication authenticatedCredentials = authenticationManager.authenticate(userCredentials);
        String tokenString = tokenService.createToken((Users)authenticatedCredentials.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(tokenString));
    }
}

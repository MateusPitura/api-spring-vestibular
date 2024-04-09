package br.com.mateus.api.avisos;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.mateus.api.exception.Utils;
import br.com.mateus.api.universidades.RepositoryUniversidades;
import br.com.mateus.api.universidades.Universidades;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/avisos")
public class ControllerAvisos {
    
    @Autowired
    private RepositoryAvisos repositoryAvisos;

    @Autowired
    private RepositoryUniversidades repositoryUniversidades;

    @PostMapping
    @Transactional
    public ResponseEntity<AvisosDTO> create(@RequestBody AvisosDTO dto, UriComponentsBuilder uri){
        Universidades universidade = Utils.getInstanceById(repositoryUniversidades, dto.universidadeId().toString());
        Avisos avisos = new Avisos(dto, universidade);
        URI path = uri.path("/avisos/{id}").buildAndExpand(avisos.getId()).toUri();
        repositoryAvisos.save(new Avisos());
        return ResponseEntity.created(path).body(new AvisosDTO(avisos));
    }

}

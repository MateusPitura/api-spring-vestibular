package br.com.mateus.api.avisos;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.mateus.api.exception.Utils;
import br.com.mateus.api.universidades.RepositoryUniversidades;
import br.com.mateus.api.universidades.Universidades;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/avisos")
public class ControllerAvisos {
    
    @Autowired
    private RepositoryAvisos repositoryAvisos;

    @Autowired
    private RepositoryAvisosPageable repositoryAvisosPageable;

    @Autowired
    private RepositoryUniversidades repositoryUniversidades;

    @PostMapping
    @Transactional
    public ResponseEntity<AvisosDTO> create(@RequestBody @Valid AvisosDTO dto, UriComponentsBuilder uri){
        Universidades universidade = Utils.getInstanceById(repositoryUniversidades, dto.universidadeId().toString());
        Avisos avisos = new Avisos(dto, universidade);
        URI path = uri.path("/avisos/{id}").buildAndExpand(avisos.getId()).toUri();
        repositoryAvisos.save(new Avisos());
        return ResponseEntity.created(path).body(new AvisosDTO(avisos));
    }

    @GetMapping
    public ResponseEntity<Page<Avisos>> list(
        @PageableDefault(size = 20, page = 0, sort = "data", direction = Sort.Direction.ASC) 
        Pageable pageable
    ){
        return ResponseEntity.ok(repositoryAvisosPageable.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvisosDTO> read(@PathVariable String id){
        Avisos avisos = Utils.getInstanceById(repositoryAvisos, id);
        return ResponseEntity.ok(new AvisosDTO(avisos));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AvisosDTO> update(@PathVariable String id, @RequestBody @Valid UpdateAvisosDTO dto){
        Avisos avisos = Utils.getInstanceById(repositoryAvisos, id);
        Universidades universidade = null;
        if(dto.universidadeId() != null){
            universidade = Utils.getInstanceById(repositoryUniversidades, dto.universidadeId().toString());
        }
        avisos.update(dto, universidade);
        return ResponseEntity.ok(new AvisosDTO(avisos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> delete(@PathVariable String id){
        Long idLong = Utils.parseIdStringToLong(id);
        Utils.getInstanceById(repositoryAvisos, id);
        repositoryAvisos.deleteById(idLong);
        return ResponseEntity.noContent().build();
    }
}

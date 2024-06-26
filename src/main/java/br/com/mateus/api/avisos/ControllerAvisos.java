package br.com.mateus.api.avisos;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.mateus.api.exception.Utils;
import br.com.mateus.api.universidades.RepositoryUniversidades;
import br.com.mateus.api.universidades.Universidades;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avisos")
public class ControllerAvisos {
    
    @Autowired
    private RepositoryAvisos repositoryAvisos;

    @Autowired
    private RepositoryUniversidades repositoryUniversidades;

    @PostMapping
    @Transactional
    public ResponseEntity<OutputAvisosDTO> create(@RequestBody @Valid AvisosDTO dto, UriComponentsBuilder uri){
        Universidades universidade = Utils.getInstanceById(repositoryUniversidades, dto.universidadeId().toString());
        Avisos avisos = new Avisos(dto, universidade);
        repositoryAvisos.save(avisos);
        URI path = uri.path("/avisos/{id}").buildAndExpand(avisos.getId()).toUri();
        return ResponseEntity.created(path).body(new OutputAvisosDTO(avisos));
    }

    @GetMapping
    public ResponseEntity<List<ReadAvisosDTO>> list(@RequestParam(name="universidade", required=false) List<String> idUniversidade){
        if(idUniversidade == null){
            return ResponseEntity.ok(repositoryAvisos.findAllItens());
        } 
        return ResponseEntity.ok(repositoryAvisos.findAllById(idUniversidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutputAvisosDTO> read(@PathVariable String id){
        Avisos avisos = Utils.getInstanceById(repositoryAvisos, id);
        return ResponseEntity.ok(new OutputAvisosDTO(avisos));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<OutputAvisosDTO> update(@PathVariable String id, @RequestBody @Valid UpdateAvisosDTO dto){
        Avisos avisos = Utils.getInstanceById(repositoryAvisos, id);
        Universidades universidade = null;
        if(dto.universidadeId() != null){
            universidade = Utils.getInstanceById(repositoryUniversidades, dto.universidadeId().toString());
        }
        avisos.update(dto, universidade);
        return ResponseEntity.ok(new OutputAvisosDTO(avisos));
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

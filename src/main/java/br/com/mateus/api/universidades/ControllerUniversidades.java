package br.com.mateus.api.universidades;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/universidades")
public class ControllerUniversidades {

    @Autowired
    private RepositoryUniversidades repositoryUniversidades;
    
    @PostMapping
    @Transactional
    public ResponseEntity<UniversidadesDTO> create(@RequestBody UniversidadesDTO dto, UriComponentsBuilder uri){
        Universidades universidades = new Universidades(dto);
        repositoryUniversidades.save(universidades);
        URI location = uri.path("/universidades/{id}").buildAndExpand(universidades.getId()).toUri();
        return ResponseEntity.created(location).body(new UniversidadesDTO(universidades));
    }

    @GetMapping
    public ResponseEntity<List<Universidades>> list(){
        return ResponseEntity.ok(repositoryUniversidades.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversidadesDTO> read(@PathVariable String id){
        Long idLong = (long)Integer.parseInt(id);
        Universidades universidades = repositoryUniversidades.getReferenceById(idLong);
        return ResponseEntity.ok(new UniversidadesDTO(universidades));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UniversidadesDTO> update(@PathVariable String id, @RequestBody UniversidadesDTO dto){
        Long idLong = (long)Integer.parseInt(id);
        Universidades universidades = repositoryUniversidades.getReferenceById(idLong);
        universidades.update(dto);
        return ResponseEntity.ok(new UniversidadesDTO(universidades));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> delete(@PathVariable String id){
        Long idLong = (long)Integer.parseInt(id);
        repositoryUniversidades.deleteById(idLong);
        return ResponseEntity.noContent().build();
    }
}

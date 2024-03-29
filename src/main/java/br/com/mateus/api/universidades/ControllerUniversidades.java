package br.com.mateus.api.universidades;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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

import br.com.mateus.api.exception.IdNotFound;
import br.com.mateus.api.exception.InvalidIdException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/universidades")
public class ControllerUniversidades {

    @Autowired
    private RepositoryUniversidades repositoryUniversidades;

    @PostMapping
    @Transactional
    public ResponseEntity<UniversidadesDTO> create(@RequestBody @Valid UniversidadesDTO dto, UriComponentsBuilder uri) {
        Universidades universidades = new Universidades(dto);
        repositoryUniversidades.save(universidades);
        URI location = uri.path("/universidades/{id}").buildAndExpand(universidades.getId()).toUri();
        return ResponseEntity.created(location).body(new UniversidadesDTO(universidades));
    }

    @GetMapping
    public ResponseEntity<List<Universidades>> list() {
        return ResponseEntity.ok(repositoryUniversidades.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversidadesDTO> read(@PathVariable String id) {
        Universidades universidades = getInstanceById(id);
        return ResponseEntity.ok(new UniversidadesDTO(universidades));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UniversidadesDTO> update(@PathVariable String id,
            @RequestBody @Valid UpdateUniversidadesDTO dto) {
        Universidades universidades = getInstanceById(id);
        universidades.update(dto);
        return ResponseEntity.ok(new UniversidadesDTO(universidades));
    }

    @SuppressWarnings("null")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> delete(@PathVariable String id) {
        Long idLong = parseIdStringToLong(id);
        getInstanceById(id);
        repositoryUniversidades.deleteById(idLong);
        return ResponseEntity.noContent().build();
    }

    private Long parseIdStringToLong(String id) {
        try {
            return (long) Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidIdException();
        }
    }

    @SuppressWarnings("null")
    private Universidades getInstanceById(String id) {
        Optional<Universidades> universidades = repositoryUniversidades.findById(parseIdStringToLong(id));
        if (universidades.isPresent()) {
            return universidades.get();
        } else {
            throw new IdNotFound();
        }
    }
}

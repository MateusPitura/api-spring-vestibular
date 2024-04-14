package br.com.mateus.api.eventos;

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
import br.com.mateus.api.universidades.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class ControllerEventos {

    @Autowired
    private RepositoryEventos repositoryEventos;

    @Autowired
    private RepositoryUniversidades repositoryUniversidades;

    @PostMapping
    @Transactional
    public ResponseEntity<EventosDTO> create(@RequestBody @Valid EventosDTO dto, UriComponentsBuilder uriComponents) {
        Universidades universidade = Utils.getInstanceById(repositoryUniversidades, dto.universidadeId().toString());
        Eventos eventos = new Eventos(dto, universidade);
        repositoryEventos.save(eventos);
        URI path = uriComponents.path("/eventos/{id}").buildAndExpand(eventos.getId()).toUri();
        return ResponseEntity.created(path).body(new EventosDTO(eventos));
    }

    @GetMapping
    public ResponseEntity<List<ReadEventosDTO>> list(@RequestParam(name="universidade", required=false) List<String> idUniversidade) {
        if(idUniversidade == null){
            return ResponseEntity.ok(repositoryEventos.findAllItens());
        } 
        return ResponseEntity.ok(repositoryEventos.findAllById(idUniversidade));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventosDTO> read(@PathVariable String id) {
        Eventos eventos = Utils.getInstanceById(repositoryEventos, id);
        return ResponseEntity.ok(new EventosDTO(eventos));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<EventosDTO> update(@PathVariable String id, @RequestBody @Valid UpdateEventosDTO dto) {
        Eventos eventos = Utils.getInstanceById(repositoryEventos, id);
        Universidades universidade = null;
        if (dto.universidadeId() != null) {
            universidade = Utils.getInstanceById(repositoryUniversidades, dto.universidadeId().toString());
        }
        eventos.update(dto, universidade);
        return ResponseEntity.ok(new EventosDTO(eventos));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> delete(@PathVariable String id) {
        Long idLong = Utils.parseIdStringToLong(id);
        Utils.getInstanceById(repositoryEventos, id);
        repositoryEventos.deleteById(idLong);
        return ResponseEntity.noContent().build();
    }
}

package br.com.mateus.api.eventos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.mateus.api.universidades.*;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/eventos")
public class ControllerEventos {
    @Autowired
    private RepositoryEventos repositoryEventos;

    @Autowired
    private RepositoryEventosPageable repositoryEventosPageable;

    @Autowired
    private RepositoryUniversidades repositoryUnividades;

    @PostMapping
    @Transactional
    public void create(@RequestBody EventosDTO dto) {
        Universidades universidade = repositoryUnividades.getReferenceById(dto.universidadeId());
        repositoryEventos.save(new Eventos(
                dto.data(),
                dto.descricao(),
                universidade));
    }

    @GetMapping
    public Page<Eventos> list(
            @PageableDefault(size = 20, page = 0, sort = "data", direction = Sort.Direction.ASC) Pageable p) {
        return repositoryEventosPageable.findAll(p);
    }

    @GetMapping("/{id}")
    public Optional<Eventos> read(@PathVariable Long id) {
        return repositoryEventos.findById(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@PathVariable Long id, @RequestBody EventosDTO dto) {
        Eventos eventos = repositoryEventos.getReferenceById(id);
        Universidades universidade = null;
        if (dto.universidadeId() != null) {
            universidade = repositoryUnividades.getReferenceById(dto.universidadeId());
        }
        eventos.update(dto, universidade);
    }
}

package br.com.mateus.api.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    private RepositoryUniversidades repositoryUnividades;

    @PostMapping
    @Transactional
    public void create(@RequestBody EventosDTO dto){
        Universidades universidade = repositoryUnividades.getReferenceById(dto.universidadeId());
        repositoryEventos.save(new Eventos(
            dto.data(),
            dto.descricao(),
            universidade
        ));
    }
}

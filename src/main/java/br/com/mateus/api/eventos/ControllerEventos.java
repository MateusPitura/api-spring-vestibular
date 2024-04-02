package br.com.mateus.api.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/eventos")
public class ControllerEventos {
    @Autowired
    private RepositoryEventos repositoryEventos;

    @PostMapping
    @Transactional
    public void create(@RequestBody EventosDTO dto){
        repositoryEventos.save(new Eventos(
            
        ));
    }
}

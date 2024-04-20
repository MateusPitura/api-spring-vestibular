package br.com.mateus.api.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.mateus.api.exception.Utils;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class ControllerEventos {

    @Autowired
    private RepositoryEventos repositoryEventos;

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
}

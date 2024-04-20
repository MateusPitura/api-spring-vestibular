package br.com.mateus.api.universidades;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.mateus.api.exception.Utils;

@RestController
@RequestMapping("/universidades")
public class ControllerUniversidades {

    @Autowired
    private RepositoryUniversidades repositoryUniversidades;

    @GetMapping
    public ResponseEntity<List<Universidades>> list() {
        return ResponseEntity.ok(repositoryUniversidades.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversidadesDTO> read(@PathVariable String id) {
        Universidades universidades = Utils.getInstanceById(repositoryUniversidades, id);
        return ResponseEntity.ok(new UniversidadesDTO(universidades));
    }
}

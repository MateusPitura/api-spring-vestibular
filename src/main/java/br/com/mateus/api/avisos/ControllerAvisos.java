package br.com.mateus.api.avisos;

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
@RequestMapping("/avisos")
public class ControllerAvisos {
    
    @Autowired
    private RepositoryAvisos repositoryAvisos;

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
}

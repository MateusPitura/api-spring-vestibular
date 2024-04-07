package br.com.mateus.api.exception;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mateus.api.universidades.Universidades;

public class Utils {

    public static Long parseIdStringToLong(String id) {
        try {
            return (long) Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidIdException();
        }
    }

    public static Universidades getInstanceById(JpaRepository<Universidades, Long> repository, String id) {
        Optional<Universidades> universidades = repository.findById(Utils.parseIdStringToLong(id));
        if (universidades.isPresent()) {
            return universidades.get();
        } else {
            throw new IdNotFound();
        }
    }
}

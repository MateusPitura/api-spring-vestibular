package br.com.mateus.api.exception;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public class Utils {

    public static Long parseIdStringToLong(String id) {
        try {
            return (long) Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidIdException();
        }
    }

    public static <T> T getInstanceById(JpaRepository<T, Long> repository, String id) {
        Optional<T> instance = repository.findById(Utils.parseIdStringToLong(id));
        if (instance.isPresent()) {
            return instance.get();
        } else {
            throw new IdNotFound();
        }
    }
}

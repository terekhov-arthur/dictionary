package ua.karazin.repository;

import org.springframework.data.repository.CrudRepository;
import ua.karazin.model.Word;

import java.util.List;

public interface WordRepository extends CrudRepository<Word, Long> {
    List<Word> findAllByValueIgnoreCaseStartingWith(String value);
    Word findByValueIgnoreCase(String value);
}

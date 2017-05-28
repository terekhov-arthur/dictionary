package ua.karazin.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.karazin.model.Word;

import java.util.List;

public interface WordRepository extends CrudRepository<Word, Long> {
    List<Word> findAllByValueIgnoreCaseContains(String value);
    Word findByValueIgnoreCase(String value);
    @Query(value = "delete from word_translations; delete from translation; delete from word;", nativeQuery = true)
    void clear();

}

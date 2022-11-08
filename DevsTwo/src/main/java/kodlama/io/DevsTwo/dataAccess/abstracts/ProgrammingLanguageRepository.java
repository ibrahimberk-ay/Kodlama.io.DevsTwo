package kodlama.io.DevsTwo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.DevsTwo.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {

}

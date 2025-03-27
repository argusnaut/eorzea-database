package br.com.argus.eorzea_database.repository;

import br.com.argus.eorzea_database.model.Job;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends MongoRepository<Job, ObjectId> {
    Optional<Job> findByAbbreviation(String abbreviation);
    List<Job> findByDiscipline(Job.Discipline discipline);
    List<Job> findByPrimaryRole(Job.Role role);
    List<Job> findByIsClass(boolean isClass);
    List<Job> findBySecondaryRolesContaining(Job.Role role);
    boolean existsByAbbreviation(String abbreviation);
}
package br.com.argus.eorzea_database.repository;

import br.com.argus.eorzea_database.model.Job;
import br.com.argus.eorzea_database.model.Trait;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TraitRepository extends MongoRepository<Trait, ObjectId> {
    List<Trait> findByJobId(ObjectId jobId);
    List<Trait> findByLevel(int level);
    List<Trait> findByIsQuestTrait(boolean isQuestTrait);
    List<Trait> findByRole(Job.Role role);
}

package br.com.argus.eorzea_database.repository;

import br.com.argus.eorzea_database.model.Action;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActionRepository extends MongoRepository<Action, ObjectId> {
    List<Action> findByJobId(ObjectId jobId);
    List<Action> findByType(Action.ActionType type);
    List<Action> findByLevelBetween(int minLevel, int maxLevel);
    List<Action> findByCastTimeBetween(float minCastTime, float maxCastTime);
    List<Action> findByRecastTimeBetween(float minRecastTime, float maxRecastTime);
}
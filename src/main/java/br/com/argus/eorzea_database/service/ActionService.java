package br.com.argus.eorzea_database.service;

import br.com.argus.eorzea_database.model.Action;
import br.com.argus.eorzea_database.repository.ActionRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActionService {
    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<Action> findAllActions() {
        return actionRepository.findAll();
    }

    public Optional<Action> findActionById(ObjectId id) {
        return actionRepository.findById(id);
    }

    public List<Action> findActionsByJobId(ObjectId jobId) {
        return actionRepository.findByJobId(jobId);
    }

    public List<Action> findActionsByType(Action.ActionType type) {
        return actionRepository.findByType(type);
    }

    public List<Action> findActionsByLevelRange(int minLevel, int maxLevel) {
        return actionRepository.findByLevelBetween(minLevel, maxLevel);
    }

    public List<Action> findActionsByCastTimeRange(float minCastTime, float maxCastTime) {
        return actionRepository.findByCastTimeBetween(minCastTime, maxCastTime);
    }

    public List<Action> findActionsByRecastTimeRange(float minRecastTime, float maxRecastTime) {
        return actionRepository.findByRecastTimeBetween(minRecastTime, maxRecastTime);
    }

    public Action saveAction(Action action) {
        return actionRepository.save(action);
    }

    public void deleteAction(ObjectId id) {
        actionRepository.deleteById(id);
    }
}
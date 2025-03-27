package br.com.argus.eorzea_database.service;

import br.com.argus.eorzea_database.model.Job;
import br.com.argus.eorzea_database.model.Trait;
import br.com.argus.eorzea_database.repository.TraitRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraitService {
    private final TraitRepository traitRepository;

    public TraitService(TraitRepository traitRepository) {
        this.traitRepository = traitRepository;
    }

    public List<Trait> findAllTraits() {
        return traitRepository.findAll();
    }

    public Optional<Trait> findTraitById(ObjectId id) {
        return traitRepository.findById(id);
    }

    public List<Trait> findTraitsByJobId(ObjectId jobId) {
        return traitRepository.findByJobId(jobId);
    }

    public List<Trait> findTraitsByLevel(int level) {
        return traitRepository.findByLevel(level);
    }

    public List<Trait> findQuestTraits(boolean isQuestTrait) {
        return traitRepository.findByIsQuestTrait(isQuestTrait);
    }

    public List<Trait> findTraitsByRole(Job.Role role) {
        return traitRepository.findByRole(role);
    }

    public Trait saveTrait(Trait trait) {
        return traitRepository.save(trait);
    }

    public void deleteTrait(ObjectId id) {
        traitRepository.deleteById(id);
    }
}
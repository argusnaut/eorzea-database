package br.com.argus.eorzea_database.controller;

import br.com.argus.eorzea_database.model.Job;
import br.com.argus.eorzea_database.model.Trait;
import br.com.argus.eorzea_database.service.TraitService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traits")
public class TraitController {
    private final TraitService traitService;

    public TraitController(TraitService traitService) {
        this.traitService = traitService;
    }

    @GetMapping
    public List<Trait> getAllTraits() {
        return traitService.findAllTraits();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trait> getTraitById(@PathVariable String id) {
        return traitService.findTraitById(new ObjectId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/job/{jobId}")
    public List<Trait> getTraitsByJob(@PathVariable String jobId) {
        return traitService.findTraitsByJobId(new ObjectId(jobId));
    }

    @GetMapping("/level/{level}")
    public List<Trait> getTraitsByLevel(@PathVariable int level) {
        return traitService.findTraitsByLevel(level);
    }

    @GetMapping("/quest")
    public List<Trait> getQuestTraits(@RequestParam boolean isQuestTrait) {
        return traitService.findQuestTraits(isQuestTrait);
    }

    @GetMapping("/role/{role}")
    public List<Trait> getTraitsByRole(@PathVariable Job.Role role) {
        return traitService.findTraitsByRole(role);
    }

    @PostMapping
    public Trait createTrait(@RequestBody @Valid Trait trait) {
        return traitService.saveTrait(trait);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trait> updateTrait(
            @PathVariable String id,
            @RequestBody @Valid Trait trait) {
        trait.setId(new ObjectId(id));
        return ResponseEntity.ok(traitService.saveTrait(trait));
    }

    @DeleteMapping("/{id}")
    public void deleteTrait(@PathVariable String id) {
        traitService.deleteTrait(new ObjectId(id));
    }
}

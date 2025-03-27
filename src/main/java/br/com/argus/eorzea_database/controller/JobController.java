package br.com.argus.eorzea_database.controller;

import br.com.argus.eorzea_database.model.Job;
import br.com.argus.eorzea_database.service.JobService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.findAllJobs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id) {
        return jobService.findJobById(new ObjectId(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/abbreviation/{abbreviation}")
    public ResponseEntity<Job> getJobByAbbreviation(@PathVariable String abbreviation) {
        return jobService.findByAbbreviation(abbreviation)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/discipline/{discipline}")
    public List<Job> getJobsByDiscipline(@PathVariable Job.Discipline discipline) {
        return jobService.findByDiscipline(discipline);
    }

    @GetMapping("/role/primary/{role}")
    public List<Job> getJobsByPrimaryRole(@PathVariable Job.Role role) {
        return jobService.findJobsByRole(role);
    }

    @GetMapping("/role/secondary/{role}")
    public List<Job> getJobsBySecondaryRole(@PathVariable Job.Role role) {
        return jobService.findJobsBySecondaryRole(role);
    }

    @GetMapping("/classes/{isClass}")
    public List<Job> getClasses(@PathVariable boolean isClass) {
        return jobService.findClasses(isClass);
    }

    @PostMapping
    public ResponseEntity<?> createJob(@RequestBody @Valid Job job) {
        if (jobService.existsByAbbreviation(job.getAbbreviation())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Job abbreviation already exists");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jobService.saveJob(job));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(
            @PathVariable String id,
            @RequestBody @Valid Job job) {
        if (!jobService.existsById(new ObjectId(id))) {
            return ResponseEntity.notFound().build();
        }
        Optional<Job> existingJob = jobService.findByAbbreviation(job.getAbbreviation());
        if (existingJob.isPresent() && !existingJob.get().getId().equals(new ObjectId(id))) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Job abbreviation already exists");
        }
        job.setId(new ObjectId(id));
        return ResponseEntity.ok(jobService.saveJob(job));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable String id) {
        if (!jobService.existsById(new ObjectId(id))) {
            return ResponseEntity.notFound().build();
        }
        jobService.deleteJob(new ObjectId(id));
        return ResponseEntity.noContent().build();
    }
}
package br.com.argus.eorzea_database.service;

import br.com.argus.eorzea_database.model.Job;
import br.com.argus.eorzea_database.repository.JobRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> findAllJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> findJobById(ObjectId id) {
        return jobRepository.findById(id);
    }

    public Optional<Job> findByAbbreviation(String abbreviation) {
        return jobRepository.findByAbbreviation(abbreviation);
    }

    public List<Job> findByDiscipline(Job.Discipline discipline) {
        return jobRepository.findByDiscipline(discipline);
    }

    public List<Job> findJobsByRole(Job.Role role) {
        return jobRepository.findByPrimaryRole(role);
    }

    public List<Job> findClasses(boolean isClass) {
        return jobRepository.findByIsClass(isClass);
    }

    public List<Job> findJobsBySecondaryRole(Job.Role role) {
        return jobRepository.findBySecondaryRolesContaining(role);
    }

    public boolean existsByAbbreviation(String abbreviation) {
        return jobRepository.existsByAbbreviation(abbreviation);
    }

    public boolean existsById(ObjectId id) {
        return jobRepository.existsById(id);
    }

    public Job saveJob(Job job) {
        if (job.isClass() && job.getEvolvesTo() != null) {
            Optional<Job> evolvesToJob = jobRepository.findById(job.getEvolvesTo());
            if (evolvesToJob.isEmpty() || evolvesToJob.get().isClass()) {
                throw new IllegalArgumentException("A job must evolve to a non-class job");
            }
        }
        return jobRepository.save(job);
    }

    public void deleteJob(ObjectId id) {
        jobRepository.deleteById(id);
    }
}
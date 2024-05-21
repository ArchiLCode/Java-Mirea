package org.example.practice19.repo;

import org.example.practice19.entities.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    Iterable<Feedback> findAllByName(String name);
}
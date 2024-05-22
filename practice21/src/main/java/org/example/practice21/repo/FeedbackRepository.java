package org.example.practice21.repo;

import org.example.practice21.entities.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    Iterable<Feedback> findAllByName(String name);
}
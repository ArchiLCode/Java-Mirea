package org.example.practice24.repo;

import org.example.practice24.entities.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    Iterable<Feedback> findAllByName(String name);
}
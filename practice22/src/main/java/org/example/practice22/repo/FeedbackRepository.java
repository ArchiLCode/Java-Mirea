package org.example.practice22.repo;

import org.example.practice22.entities.Feedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends CrudRepository<Feedback, Long> {
    Iterable<Feedback> findAllByName(String name);
}
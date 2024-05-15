package org.example.practice17.services;

import lombok.AllArgsConstructor;
import org.example.practice17.entities.Feedback;
import org.example.practice17.repositories.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class FeedbackService {
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getFeedbacks() throws SQLException {
        return feedbackRepository.getFeedbacks();
    }
    public Feedback addFeedback(Feedback feedback) throws SQLException {
        return feedbackRepository.addFeedback(feedback);
    }

    public boolean deleteFeedback(int id) throws SQLException {
        return feedbackRepository.deleteFeedback(id);
    }
    public List<Feedback> getSpecificFeedback(String name) {
        return feedbackRepository.getSpecificFeedback(name);
    }
}
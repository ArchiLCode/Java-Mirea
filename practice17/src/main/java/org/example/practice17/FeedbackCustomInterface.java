package org.example.practice17;

import org.example.practice17.entities.Feedback;

import java.util.List;

public interface FeedbackCustomInterface {
    List<Feedback> getSpecificFeedback(String name);
}
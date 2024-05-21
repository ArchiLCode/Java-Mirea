package org.example.practice17.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.practice17.entities.Feedback;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FeedbackRepository {
    private final DataSource ds;

    @PersistenceContext
    private EntityManager entityManager;

    public FeedbackRepository(DataSource ds) {
        this.ds = ds;
    }

    public List<Feedback> getFeedbacks() throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("select * from feedbacks");
        ResultSet rs = ps.executeQuery();
        List<Feedback> feedbacks = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String description = rs.getString(3);
            int product_id = rs.getInt(4);
            feedbacks.add(new Feedback(id, name, description, product_id));
        }
        return feedbacks;
    }

    public Feedback addFeedback(Feedback feedback) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into feedbacks (id, name, description, product_id) values (?, ?, ?, ?)", new String[] {"id"});
        ps.setInt(1, feedback.getId());
        ps.setString(2, feedback.getName());
        ps.setString(3, feedback.getDescription());
        ps.setInt(4, feedback.getProduct_id());
        ps.executeUpdate();
        return feedback;
    }

    public boolean deleteFeedback(int id) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement("delete from feedbacks where id = ?");
        ps.setInt(1, id);
        return ps.executeUpdate() > 0;
    }

    public List<Feedback> getSpecificFeedback(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Feedback> criteriaQuery = criteriaBuilder.createQuery(Feedback.class);
        Root<Feedback> root = criteriaQuery.from(Feedback.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}

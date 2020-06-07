package ImageHoster.repository;

import ImageHoster.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {

    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

  //add comments to DataBase
    public void addComment(Comment comment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
    }
}

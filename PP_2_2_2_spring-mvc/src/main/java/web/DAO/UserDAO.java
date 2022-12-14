package web.DAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Component
@Transactional
public class UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> index() {  //getAll
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User show(int id) { //select1
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(int id) {
        entityManager.remove(show(id));
    }
}



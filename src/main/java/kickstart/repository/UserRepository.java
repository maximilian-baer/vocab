package kickstart.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import kickstart.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User user){
        entityManager.persist(user);
    }

    public List<User> findAll(){
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList();
    }

    public Optional<User> findById(Long id){
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Transactional
    public User update(User user){
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteById(Long id){
        entityManager.remove(entityManager.find(User.class, id));
    }
}

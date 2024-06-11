package com.example.velocerentals.repositories.users;

import com.example.velocerentals.domain.model.User;
import com.example.velocerentals.domain.model.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional

public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> listUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User byIdUser(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void removeUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }
}

package com.lhind.project.repository;

import com.lhind.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    List<User> findAll();
    User findById(int id);
//    final String GETALL = "SELECT User FROM User user";
//    final EntityManager entityManager;
//
//    public default List<User> getAll(){
//
//        return entityManager.createQuery(GETALL).getResultList();
//    }
}

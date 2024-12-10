package com.example.tarotapplication.repository;

import com.example.tarotapplication.model.User;
import com.example.tarotapplication.model.UserLuck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserLuckRepository extends JpaRepository<UserLuck, Long> {
    Optional<UserLuck> findTopByUserOrderByDateAddedDesc(User user);
    UserLuck findByUser(User user);
    boolean existsByUser(User user);
}
package com.example.tarotapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_luck")
public class UserLuck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Integer luckScore = 0;
    private String luckDescription;
    private LocalDateTime dateAdded;

    @PrePersist
    protected void onCreate() {
        dateAdded = LocalDateTime.now();
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void modifyLuck(Integer score) {
        this.luckScore += score; 
    }
    // Add getter for luckScore
    public Integer getLuckScore() {
        return luckScore;
    }
}
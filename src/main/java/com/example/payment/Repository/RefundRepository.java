package com.example.payment.Repository;

import com.example.payment.Entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefundRepository extends JpaRepository<Refund,Integer> {
    @Query("SELECT r.user.userId, SUM(r.amount) FROM Refund r GROUP BY r.user.userId ORDER BY SUM(r.amount) DESC")
    List<Object[]> findUserIdWithMaxRefundAmount();
}

package com.example.payment.Repository;

import com.example.payment.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TranscationRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findByIsSuccess(boolean isSuccess);
}

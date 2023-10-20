package com.example.payment.Service;

import com.example.payment.Entity.Transaction;
import com.example.payment.Entity.User;
import com.example.payment.Repository.TranscationRepository;
import com.example.payment.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TranscationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TranscationRepository transcationRepository;

    @Autowired
    private UserService userService;
    public String addTranscation(Transaction transaction, Integer userId) {

        Optional<User> optionalUser=userRepository.findById(userId);
        User user=optionalUser.get();
        transaction.setUser(user);
        List<Transaction> list=user.getTransactionList();
        list.add(transaction);
        user.setTransactionList(list);
        userRepository.save(user);
        return "transcation is added";
    }

    public double getTotalSuccessfulTransactionsAmount(Integer userId) {

        Optional<User> optionalUser=userRepository.findById(userId);
        optionalUser.get();
        List<Transaction> successfulTransactions = transcationRepository.findByIsSuccess(true);
        double totalAmount = 0.0;
        for (Transaction transaction : successfulTransactions) {
            if (transaction.getUser().getUserId().equals(userId)) {
                totalAmount += transaction.getAmount();
            }
        }
        return totalAmount;
    }

    public void deleteFailedTransactions() {
        List<Transaction> failedTransactions = transcationRepository.findByIsSuccess(false);
        transcationRepository.deleteAll(failedTransactions);
    }
}

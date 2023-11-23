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
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TranscationRepository transcationRepository;
    public String addUser(User user) {
        userRepository.save(user);
        return "User added";
    }
    public String deleteFailedTransactions(Integer userId)
    {
        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()) return "invalid userId";

        List<Transaction> optionalTransaction = transcationRepository.findAll();
        for(int i=0; i<optionalTransaction.size(); i++)
        {
            Transaction t = optionalTransaction.get(i);
            if(t.getUser() != null && t.getUser().getUserId() == userId && t.getIsSuccess() == false)
            {
                t.setUser(null);
                transcationRepository.save(t);
            }
        }
        return "deleted successfully";

    }
}

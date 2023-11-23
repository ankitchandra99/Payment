package com.example.payment.Controller;


import com.example.payment.Entity.Transaction;
import com.example.payment.Entity.User;
import com.example.payment.Repository.UserRepository;
import com.example.payment.Service.TranscationService;
import com.example.payment.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/transcations")
public class TranscationController {

    @Autowired
    private TranscationService transcationService;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity addTranscation(@RequestBody Transaction transaction, @RequestParam("userId") Integer userId){
        String result=transcationService.addTranscation(transaction,userId);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/total/{userId}")
    public double getTotalSuccessfulTransactionsAmount(@PathVariable Integer userId) {

        return transcationService.getTotalSuccessfulTransactionsAmount(userId);

    }

    @DeleteMapping("/failed")
    public String deleteFailedTransactions(@RequestParam Integer userId)
    {
        return userService.deleteFailedTransactions(userId);
    }
}

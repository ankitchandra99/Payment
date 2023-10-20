package com.example.payment.Service;

import com.example.payment.Repository.RefundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RefundService {
    @Autowired
    private RefundRepository refundRepository;

    public List<Object[]> getUserIdWithMaxRefundAmount() {
        return refundRepository.findUserIdWithMaxRefundAmount();
    }
}

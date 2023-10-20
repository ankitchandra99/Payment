package com.example.payment.Controller;

import com.example.payment.Service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/refund")
public class RefundController {
    @Autowired
    private RefundService refundService;

    @GetMapping("/max")
    public List<Object[]> getUserIdWithMaxRefundAmount() {
        return refundService.getUserIdWithMaxRefundAmount();
    }
}
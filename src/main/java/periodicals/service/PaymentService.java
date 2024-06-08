package periodicals.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import periodicals.repository.PaymentRepository;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    // Business logic methods
}


package periodicals.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import periodicals.dto.PaymentDto;
import periodicals.model.Payment;
import periodicals.model.Subscription;
import periodicals.repository.PaymentRepository;
import periodicals.repository.SubscriptionRepository;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final SubscriptionRepository subscriptionRepository;

    public PaymentService(PaymentRepository paymentRepository, SubscriptionRepository subscriptionRepository) {
        this.paymentRepository = paymentRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public Payment createPayment(PaymentDto paymentDto) {
        Subscription subscription = subscriptionRepository.findById(paymentDto.getSubscriptionId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Subscription not found"));

        Payment payment = new Payment();
        payment.setSubscription(subscription);
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentDate(paymentDto.getPaymentDate());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}



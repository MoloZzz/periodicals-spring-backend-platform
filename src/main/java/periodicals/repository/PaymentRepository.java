package periodicals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import periodicals.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}


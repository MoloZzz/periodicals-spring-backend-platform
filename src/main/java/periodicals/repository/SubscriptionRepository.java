package periodicals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import periodicals.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}


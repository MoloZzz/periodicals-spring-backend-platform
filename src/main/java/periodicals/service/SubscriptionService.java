package periodicals.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import periodicals.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    // Business logic methods
}


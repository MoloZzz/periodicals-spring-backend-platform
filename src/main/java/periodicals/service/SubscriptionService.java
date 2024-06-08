package periodicals.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import periodicals.dto.SubscriptionDto;
import periodicals.model.Publication;
import periodicals.model.Subscription;
import periodicals.model.User;
import periodicals.repository.PublicationRepository;
import periodicals.repository.SubscriptionRepository;
import periodicals.repository.UserRepository;

import java.util.List;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final PublicationRepository publicationRepository;
    private final UserRepository userRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, PublicationRepository publicationRepository, UserRepository userRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.publicationRepository = publicationRepository;
        this.userRepository = userRepository;
    }

    public Subscription createSubscription(SubscriptionDto subscriptionDto) {
        User user = userRepository.findById(subscriptionDto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
        Publication publication = publicationRepository.findById(subscriptionDto.getPublicationId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Publication not found"));

        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPublication(publication);
        subscription.setStartDate(subscriptionDto.getStartDate());
        subscription.setEndDate(subscriptionDto.getEndDate());

        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }
}



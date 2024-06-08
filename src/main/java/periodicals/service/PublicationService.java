package periodicals.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import periodicals.repository.PublicationRepository;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    // Business logic methods
}

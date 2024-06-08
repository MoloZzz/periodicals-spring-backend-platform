package periodicals.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import periodicals.model.Publication;
import periodicals.repository.PublicationRepository;

import java.util.List;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public Publication savePublication(Publication publication) {
        return publicationRepository.save(publication);
    }

    public Publication updatePublication(Long id, Publication publication) {
        Publication existingPublication = publicationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Publication not found"));
        existingPublication.setTitle(publication.getTitle());
        existingPublication.setDescription(publication.getDescription());
        existingPublication.setPrice(publication.getPrice());
        existingPublication.setIssueFrequency(publication.getIssueFrequency());
        return publicationRepository.save(existingPublication);
    }

    public void deletePublication(Long id) {
        publicationRepository.deleteById(id);
    }

    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }
}


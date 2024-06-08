package periodicals.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import periodicals.dto.PublicationDto;
import periodicals.model.Publication;
import periodicals.repository.PublicationRepository;

import java.util.List;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public Publication createPublication(PublicationDto publication) {
        Publication newPublication = new Publication();
        newPublication.setTitle(publication.getTitle());
        newPublication.setDescription(publication.getDescription());
        newPublication.setPrice(publication.getPrice());
        newPublication.setIssueFrequency(publication.getIssueFrequency());
        return publicationRepository.save(newPublication);
    }

    public Publication updatePublication(Long id, PublicationDto publication) {
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


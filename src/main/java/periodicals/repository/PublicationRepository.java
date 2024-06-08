package periodicals.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import periodicals.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
}


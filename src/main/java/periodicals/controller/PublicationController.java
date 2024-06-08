package periodicals.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import periodicals.dto.PublicationDto;
import periodicals.model.Publication;
import periodicals.service.PublicationService;

import java.util.List;

@RestController
@RequestMapping("/publications")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;

    @PostMapping
    public ResponseEntity<Publication> createPublication(@RequestBody PublicationDto publicationDto) {
        Publication savedPublication = publicationService.createPublication(publicationDto);
        return ResponseEntity.ok(savedPublication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable Long id, @RequestBody PublicationDto publicationDto) {
        Publication updatedPublication = publicationService.updatePublication(id, publicationDto);
        return ResponseEntity.ok(updatedPublication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        publicationService.deletePublication(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Publication>> getAllPublications() {
        List<Publication> publications = publicationService.getAllPublications();
        return ResponseEntity.ok(publications);
    }
}


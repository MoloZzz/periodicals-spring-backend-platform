package periodicals.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicationDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String issueFrequency;
}

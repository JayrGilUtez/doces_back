package mx.edu.utez.doces_back.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "files")
@AllArgsConstructor
public class File {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String type;
    @Lob
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "fk_document_request")
    private DocumentRequest documentRequest;


}

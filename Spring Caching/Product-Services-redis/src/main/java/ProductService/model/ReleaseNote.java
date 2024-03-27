package ProductService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
public class ReleaseNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String version;
    private LocalDateTime date;
    private String changeLogData;

    public ReleaseNote(String version, LocalDateTime date, String changeLogData) {
        this.version = version;
        this.date = date;
        this.changeLogData = changeLogData;

    }
}

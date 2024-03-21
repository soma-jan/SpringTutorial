package ProductService.Exception;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date date, String message, String description) {
        this.timestamp=date;
        this.message=message;
        this.details=description;
    }
}

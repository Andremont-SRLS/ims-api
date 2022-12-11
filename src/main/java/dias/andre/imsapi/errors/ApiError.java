package dias.andre.imsapi.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;
@Getter
public class ApiError {
    private String message;
    private HttpStatus status;
    private List<String> errors;

    public ApiError(HttpStatus status, String message,  List<String> errors) {
        super();
        this.message = message;
        this.status = status;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, String error) {
        super();
        this.message = message;
        this.status = status;
        this.errors = Arrays.asList(error);
    }

}

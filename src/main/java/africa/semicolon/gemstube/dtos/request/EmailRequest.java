package africa.semicolon.gemstube.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class EmailRequest {
    private Sender sender;
    @JsonProperty("to")
    private List<Recipient> recipients;
    private String htmlContent;
    private String subject;
}
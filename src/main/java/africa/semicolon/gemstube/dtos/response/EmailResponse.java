package africa.semicolon.gemstube.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Setter
@Getter
public class EmailResponse {
    private String messageId;
    private Integer code;
}

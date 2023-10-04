package africa.semicolon.gemstube.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Recipient {
    private String email;
    private String name;
}

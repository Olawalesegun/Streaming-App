package africa.semicolon.gemstube.dtos.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class Sender {
    private String email = "gemstube@hotmail.africa";
    private String name = "Gemstube inc.";

    public Sender(String email, String name){
        this.email = email;
        this.name = name;
    }
}

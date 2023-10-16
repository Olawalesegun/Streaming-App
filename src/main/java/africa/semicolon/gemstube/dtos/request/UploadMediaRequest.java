package africa.semicolon.gemstube.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class UploadMediaRequest {
    private Long creatorId;
    private MultipartFile multipartFile;
    private String description;
    private String title;
}

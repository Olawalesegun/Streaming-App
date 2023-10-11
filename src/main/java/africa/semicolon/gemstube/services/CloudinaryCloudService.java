package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.exceptions.MediaUploadException;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class CloudinaryCloudService implements CloudService{
    private final Cloudinary cloudinary;
    @Override
    public String upload(MultipartFile multipartfile) throws MediaUploadException {
        /*To know more about cloudinary and uploads visit:
         https://cloudinary.com/documentation/java_quickstart*/
//
//         Cloudinary cloudinary =
        // we took the CLoudinary object away into the Cloud Config because we do not want
        // that when objects are created everytime the upload is called.

        try{
            Map<?, ?> uploadResponse = cloudinary.uploader().upload(multipartfile.getBytes(),
                    ObjectUtils.emptyMap());
            log.info("upload response -->{}", uploadResponse);
            String url = (String)uploadResponse.get("secure_url");
            return url;
        }catch(IOException ioException){
            throw new MediaUploadException(ioException.getMessage());
        }

    }
}

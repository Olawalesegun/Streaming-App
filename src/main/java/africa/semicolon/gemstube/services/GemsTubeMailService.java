package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.config.MailConfig;
import africa.semicolon.gemstube.dtos.request.EmailRequest;
import africa.semicolon.gemstube.dtos.response.EmailResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.*;

import static org.springframework.http.HttpMethod.POST;
import  static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
@Service
@AllArgsConstructor
public class GemsTubeMailService implements MailService{
    private final MailConfig mailConfig;
    @Override
    public EmailResponse sendMail(EmailRequest emailRequest) {
        final String URLi = mailConfig.getBrevoMailUrl();
        final String MY_API_KEY = mailConfig.getMailApiKey();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
       // httpHeaders.setAccept(List.of(APPLICATION_JSON));
        httpHeaders.set("accept", APPLICATION_JSON_VALUE); //this does the same thing as above
        httpHeaders.set("api-key", MY_API_KEY);
        HttpEntity<EmailRequest> requestEntity = new RequestEntity<>(emailRequest,httpHeaders, POST, URI.create(""));
        ResponseEntity<EmailResponse> response =
                restTemplate.postForEntity(URLi,
                        requestEntity, EmailResponse.class);

        var emailResponse = response.getBody();
        // HttpStatusCode statusCode = response.getStatusCode();
        // emailResponse.setCode(Integer.valueOf(response.getHeaders().get("status").toString()));
        emailResponse.setCode(response.getStatusCode().value());

        return emailResponse;
    }
}
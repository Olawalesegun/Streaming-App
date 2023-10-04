package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.request.EmailRequest;
import africa.semicolon.gemstube.dtos.request.Recipient;
import africa.semicolon.gemstube.dtos.request.Sender;
import africa.semicolon.gemstube.dtos.response.EmailResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSendEmail(){
        Sender sender = new Sender();
        sender.setEmail("org@gmail.com");
        sender.setName("Ominikun");

        Recipient recipient = new Recipient();
        recipient.setEmail("olawalesegun0@gmail.com");
        recipient.setName("OlaMoney");
        List<Recipient> recipients = List.of(recipient);

        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setSender(sender);
        emailRequest.setRecipients(recipients);
        emailRequest.setHtmlContent("" +
                "<p>We are testing  our App</p>");
        emailRequest.setSubject("testing 123");

        EmailResponse response = mailService.sendMail(emailRequest);
        assertNotNull(response);
        assertNotNull(response.getMessageId());
    }
}

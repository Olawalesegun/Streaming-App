package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.request.EmailRequest;
import africa.semicolon.gemstube.dtos.request.Recipient;
import africa.semicolon.gemstube.dtos.request.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MailServiceTest {

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
        emailRequest.setRecipients();
    }
}

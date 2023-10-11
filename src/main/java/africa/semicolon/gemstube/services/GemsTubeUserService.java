package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.request.EmailRequest;
import africa.semicolon.gemstube.dtos.request.Recipient;
import africa.semicolon.gemstube.dtos.request.RegisterRequest;
import africa.semicolon.gemstube.dtos.response.RegisterResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;
import africa.semicolon.gemstube.models.User;
import africa.semicolon.gemstube.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GemsTubeUserService implements UserService {
    private final UserRepository userRepository;
    private final MailService mailService;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        User savedUser = userRepository.save(user);

        //Trying to send this user a mail upon registering
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setRecipients(List.of(new Recipient(savedUser.getEmail(), "friend")));
        emailRequest.setHtmlContent("<p>Hi, welcome to gemstube.com, we are so...");
        emailRequest.setSubject("Welcome to Gemstube streaming service");
        mailService.sendMail(emailRequest);

        return new RegisterResponse(savedUser.getId());
    }

    @Override
    public User getUserById(Long id) throws GemsTubeException {
        return userRepository.findById(id).orElseThrow(
                () -> new GemsTubeException(String.format("user with id %d not found", id))
        );
    }
}

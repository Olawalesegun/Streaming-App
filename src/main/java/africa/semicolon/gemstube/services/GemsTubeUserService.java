package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.request.RegisterRequest;
import africa.semicolon.gemstube.dtos.response.RegisterResponse;
import africa.semicolon.gemstube.models.User;
import africa.semicolon.gemstube.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GemsTubeUserService implements UserService {
    private final UserRepository userRepository;
    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword((registerRequest.getPassword()));
        User savedUser = userRepository.save(user);
        return new RegisterResponse(savedUser.getId());
    }
}

package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.response.RegisterResponse;
import africa.semicolon.gemstube.dtos.request.RegisterRequest;

public interface UserService {
    RegisterResponse register(RegisterRequest registerRequest);
}

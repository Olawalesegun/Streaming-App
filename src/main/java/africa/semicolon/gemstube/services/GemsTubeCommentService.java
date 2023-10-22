package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.request.CreateCommentRequest;
import africa.semicolon.gemstube.dtos.response.CreateCommentResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;
import africa.semicolon.gemstube.models.Media;
import africa.semicolon.gemstube.models.User;
import africa.semicolon.gemstube.repositories.CommentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;

public class GemsTubeCommentService implements CommentService {
    private final UserService userService;
    private final MediaService mediaService;
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public CreateCommentResponse createComment(CreateCommentRequest createCommentRequest) throws GemsTubeException {
        User commenter = userService.getUserById(createCommentRequest.getCommenterId());
        Media mediaToBeCommented = mediaService.getMediaById(createCommentRequest.getMediaId());

        return null;
    }
}

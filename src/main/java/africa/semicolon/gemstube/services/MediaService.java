package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dtos.request.UploadMediaRequest;
import africa.semicolon.gemstube.dtos.response.UploadMediaResponse;
import africa.semicolon.gemstube.exceptions.GemsTubeException;

public interface MediaService {
    UploadMediaResponse upload(UploadMediaRequest uploadMediaRequest) throws GemsTubeException;
}

package shop.goodcasting.api.file.service;

import shop.goodcasting.api.file.domain.FileDTO;
import shop.goodcasting.api.file.domain.FileVO;

import java.io.File;
import java.util.List;

public interface FileService {
    void extractVideoThumbnail(File file) throws Exception;

    List<FileDTO> findFileListByProfileId(Long profileId);

    default FileDTO entity2dto(FileVO file) {
        return FileDTO.builder()
                .fileId(file.getFileId())
                .fileName(file.getFileName())
                .uuid(file.getUuid())
                .first(file.isFirst())
                .profile(file.getProfile())
                .hire(file.getHire())
                .build();
    }
}

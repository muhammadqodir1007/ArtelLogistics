package com.example.artel.image;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageDataService {

    private ImageRepository imageDataRepository;

    public ImageData uploadImage(MultipartFile file) throws IOException {

        return imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

    }

    @Transactional
    public ImageData getInfoByImageById(Long id) {
        Optional<ImageData> dbImage = imageDataRepository.findById(id);
        if (dbImage.isEmpty()) {
            return null;
        }
        return ImageData.builder()

                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

    }

    @Transactional
    public byte[] getImage(Long id) {
        Optional<ImageData> dbImage = imageDataRepository.findById(id);
        if (dbImage.isEmpty()) return null;
        return ImageUtil.decompressImage(dbImage.get().getImageData());
    }


}
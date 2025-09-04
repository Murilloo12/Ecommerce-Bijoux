package br.com.murillo.ecommerce.service.upload;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    public String uploadFile(MultipartFile file);
}

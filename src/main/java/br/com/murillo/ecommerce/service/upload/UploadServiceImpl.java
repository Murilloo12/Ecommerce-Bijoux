package br.com.murillo.ecommerce.service.upload;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class UploadServiceImpl implements IUploadService{

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            System.out.println("DEBUG - Nome origianl do arquivo: " + file.getOriginalFilename());
            String pastaDestino = "C:\\Users\\liloo\\OneDrive\\Documentos\\Ecommerce-Bijoux-Front\\images";
            Path path = Paths.get(pastaDestino + File.separator + file.getOriginalFilename());
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return  file.getOriginalFilename();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

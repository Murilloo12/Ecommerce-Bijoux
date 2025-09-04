package br.com.murillo.ecommerce.controller;

import br.com.murillo.ecommerce.service.upload.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.murillo.ecommerce.dto.PathToFileDTO;

@RestController
@CrossOrigin("*")
public class UploadController {

    @Autowired
    private IUploadService uploadService;

    @PostMapping("/upload")
    public ResponseEntity<PathToFileDTO> uploadFile(@RequestParam(name ="arquivo")MultipartFile arquivo) {
        String filename = uploadService.uploadFile(arquivo);
        if (filename != null) {
            PathToFileDTO pathToFileDTO = new PathToFileDTO(filename);
            return ResponseEntity.status(201).body(pathToFileDTO);
        }
        return ResponseEntity.badRequest().build();
    }

}

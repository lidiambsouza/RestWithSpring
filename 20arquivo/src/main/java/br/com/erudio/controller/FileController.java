package br.com.erudio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.erudio.data.vo.v1.UploadFileResponseVO;
import br.com.erudio.services.FileStorageServices;
import io.swagger.annotations.Api;

@Api(value = "File endpoint", description = "endpoint to file", tags="FileController")
@RestController
@RequestMapping("/api/file/v1")
public class FileController {
    
    @Autowired
    private FileStorageServices fileStorageServices;

    @PostMapping(value = "/uploadFile")
    public UploadFileResponseVO uploadFile(@RequestParam("file") MultipartFile file) {

        String fileName = fileStorageServices.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/api/file/v1/downloadFile/")
        .path(fileName)
        .toUriString();

        return new UploadFileResponseVO(fileName, fileDownloadUri,file.getContentType(),file.getSize());
    }
}
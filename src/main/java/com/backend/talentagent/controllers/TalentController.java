package com.backend.talentagent.controllers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;


import com.backend.talentagent.models.Talent;
import com.backend.talentagent.services.TalentService;
import com.backend.talentagent.storage.StorageService;
import com.backend.talentagent.storage.UploadFileResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletRequest;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/talent")
public class TalentController {

    @Autowired
    private TalentService talentService;

    @Autowired
    private StorageService storageService;

    @GetMapping
    public ResponseEntity<?> findAllTalent() {
        List<Talent> talents = talentService.findAllTalent();
        return ResponseEntity.ok().body(talents);
    }



    @PostMapping("/add")
    public ResponseEntity<?> addTalent(@RequestBody Talent talent) {

        try {
            Talent prod = talentService.addTalent(talent);

            return ResponseEntity.ok().body(prod);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    } 

    @PostMapping("/addt")
    public ResponseEntity<?> addTalentMultipart(Talent talent, @RequestParam("file") MultipartFile file) {

        try {
            String fileName = storageService.storeFile(file);
            Talent tale = talent;
            if (fileName.contains(".")) {
                String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/talent/downloadFile/").path(fileName).toUriString();
                        
                tale.setTaleImage(fileDownloadUri);
            }
            return ResponseEntity.ok().body(talentService.addTalent(tale));

        } catch (Exception e) {
    
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/findById")
    public ResponseEntity<?> findTalentById(@PathParam("id") Long id) {

        Optional<Talent> Talent = talentService.findTalentById(id);

        if (!Talent.isPresent()) {
            return ResponseEntity.badRequest().body("Data not found");
        }

        return ResponseEntity.ok().body(Talent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTalentById(@PathVariable("id") Long id) {

        try {
            talentService.deleteTalentById(id);
            return ResponseEntity.ok().body("Record has been deleted");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Record not found");
        }
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = storageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/talent/downloadFile/")
                .path(fileName).toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = storageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
           //
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files).stream().map(file -> uploadFile(file)).collect(Collectors.toList());
    }

}
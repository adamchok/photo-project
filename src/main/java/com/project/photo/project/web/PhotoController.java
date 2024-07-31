package com.project.photo.project.web;

import com.project.photo.project.model.Photo;
import com.project.photo.project.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotoController {
    // CRUD REST API = Create Update Delete API
    // This class focuses on communicating with the front-end - read and send JSON files.

    // Get data from database through a service
    private final PhotoService photoService;

    // Constructor injection!
    @Autowired
    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello! Welcome to the Photo Project!";
    }

    @GetMapping("/photos")
    public Iterable<Photo> getPhotos() {
        return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo getPhoto(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photos/delete/{id}")
    public void deletePhoto(@PathVariable Integer id) {
        photoService.remove(id);
    }

    @PostMapping("/photos/upload")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(),file.getBytes());
    }

}

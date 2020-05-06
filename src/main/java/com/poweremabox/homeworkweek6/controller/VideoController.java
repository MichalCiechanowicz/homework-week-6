package com.poweremabox.homeworkweek6.controller;

import com.poweremabox.homeworkweek6.model.Video;
import com.poweremabox.homeworkweek6.service.EmailAspect;
import com.poweremabox.homeworkweek6.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping
    public ResponseEntity<List<Video>> getVideos() {
        return new ResponseEntity<>(videoService.getVideos(), HttpStatus.OK);
    }

    @EmailAspect
    @PostMapping
    public ResponseEntity<Video> addVideo(@RequestBody Video video) {
        boolean add = videoService.addVideos(video);
        if (add) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

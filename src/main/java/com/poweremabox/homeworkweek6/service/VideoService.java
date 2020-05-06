package com.poweremabox.homeworkweek6.service;

import com.poweremabox.homeworkweek6.model.Video;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private List<Video> videos;

    public VideoService() {
        this.videos = new ArrayList<>();
        videos.add(new Video("Janosik", "StudioA", 1980));
        videos.add(new Video("Kogiel Mogiel", "TVP", 1976));
    }

    public List<Video> getVideos() {
        return videos;
    }

    public boolean addVideos(Video newVideo) {
        Optional<Video> findSameVideo = videos.stream()
                .filter(video -> video.getName().equals(newVideo.getName())).findFirst();
        if(!findSameVideo.isPresent()){
            videos.add(newVideo);
            return true;
        }
        return false;
    }
}

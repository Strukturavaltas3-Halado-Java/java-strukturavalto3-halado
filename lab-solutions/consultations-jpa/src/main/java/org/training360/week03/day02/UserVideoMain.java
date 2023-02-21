package org.training360.week03.day02;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class UserVideoMain {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");

        UserRepository userRepository = new UserRepository(factory);
        VideoRepository videoRepository = new VideoRepository(factory);

        userRepository.registerUser(new YoutubeUser("username", LocalDate.now()));

        videoRepository.saveVideo(new Video("First Video",123));

        YoutubeUser user = userRepository.updateUserWithVideo(1L,new Video("Second",123) );

        System.out.println(user.getVideos().size());
        //System.out.println(videoRepository.findVideoById(2L).getUser().getName());


        //System.out.println(userRepository.findUser(1L).getVideos().get(0).getTitle());

        //videoRepository.connectVideoToUser(1L,1L);
    }
}

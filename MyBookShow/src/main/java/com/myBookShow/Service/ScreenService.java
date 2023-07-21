package com.myBookShow.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBookShow.Entity.Movie;
import com.myBookShow.Entity.ScheduledMovie;
import com.myBookShow.Entity.Screen;
import com.myBookShow.Repositry.ScreenRepository;

@Service
public class ScreenService {
	
	@Autowired
	private  ScreenRepository screenRepository;
	
	
	public Movie findMoviePlayingAtTime(Screen screen, LocalDateTime targetTime) {
        for (ScheduledMovie scheduledMovie : screen.getScheduledMovies()) {
            LocalDateTime startTime = scheduledMovie.getStartTime();
            int durationMinutes = scheduledMovie.getDurationMinutes();
            LocalDateTime endTime = startTime.plusMinutes(durationMinutes);

            if (targetTime.isAfter(startTime) && targetTime.isBefore(endTime)) {
                return scheduledMovie.getMovie();
            }
        }

        return null;
    }


	public void saveScreen(Screen screen) {
		
		
		screenRepository.save(screen);
		return;
		
		
	}
}








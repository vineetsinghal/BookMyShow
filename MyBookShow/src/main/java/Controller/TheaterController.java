package Controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myBookShow.Entity.Movie;
import com.myBookShow.Entity.ScheduledMovie;
import com.myBookShow.Entity.Screen;
import com.myBookShow.Entity.Theater;
import com.myBookShow.Service.ScreenService;
import com.myBookShow.Service.TheaterService;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
    
	@Autowired
    private TheaterService theaterService;
	
	@Autowired
	private ScreenService screenService;

	@PostMapping("/{theaterId}/screens/{screenId}/schedule")
    public Screen addScheduledMovieToScreen(
            @PathVariable Long theaterId,
            @PathVariable Long screenId,
            @RequestBody ScheduledMovie scheduledMovie
    ) {
        Theater theater = theaterService.getTheaterById(theaterId);
        Screen screen = theater.getScreens().stream()
                .filter(s -> s.getId().equals(screenId))
                .findFirst()
                .orElse(null);

        if (screen != null) {
            screen.addScheduledMovie(scheduledMovie);
            screenService.saveScreen(screen);
        }

        return screen;
    }
	
	@GetMapping("/{theaterId}/screens/{time}")
    public Map<Screen, Movie> getMoviesAtTimeForTheater(
            @PathVariable Long theaterId,
            @PathVariable String time
    ) {
        LocalDateTime targetTime = LocalDateTime.parse(time);

        Theater theater = theaterService.getTheaterById(theaterId);

        Map<Screen, Movie> moviesAtTime = new LinkedHashMap<>();

        for (Screen screen : theater.getScreens()) {
            Movie movieAtTime = screenService.findMoviePlayingAtTime(screen, targetTime);
            if (movieAtTime != null) {
                moviesAtTime.put(screen, movieAtTime);
            }
        }

        return moviesAtTime;
    }


    
}
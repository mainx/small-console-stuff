import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MoviesDB implements WordDB {
    private ArrayList<Movie> movies;

    protected MoviesDB(String source) {
        this.movies = new ArrayList<>();

        File txt = new File(source);
        Scanner line = null;

        try {
            line = new Scanner(txt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (line != null && line.hasNextLine()) {
            Movie movie = new Movie(line.nextLine());
            this.movies.add(movie);
        }
    }

    @Override
    public Movie getRandom() {
        Random randIndex = new Random();
        return movies.get(randIndex.nextInt(movies.size()));
    }
}

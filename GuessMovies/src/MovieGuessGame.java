import java.util.ArrayList;
import java.util.Scanner;

public class MovieGuessGame {
    private MoviesDB db;
    private Movie movie;
    private ArrayList<String> wrongLetters;
    private int points;

    public MovieGuessGame(String moviesListSource) {
        this.db = new MoviesDB(moviesListSource);
        this.wrongLetters = new ArrayList<>();
        this.points = 10;
    }

    public void start() {
        this.movie = db.getRandom();

        while (movie.getHiddenName().contains("_")) {
            if (this.points <= 0) {
                System.out.println("You're out of points. You lose the game.");
                return;
            }

            printInfo();
            String letter = guess();

            if (checkIfCoincidence(letter)) {
                movie.updateHiddenName(letter);
            } else {
                this.wrongLetters.add(letter);
                this.points -= 1;
            }
        }

        System.out.println("You win!");
        System.out.printf("You have guessed '%s' correctly!", movie.getName());
    }

    private boolean checkIfCoincidence(String letter) {
        return movie.getName().contains(letter);
    }

    private void printInfo() {
        System.out.printf("You are guessing: %s\n", this.movie.getHiddenName());

        System.out.printf("You have guessed (%d) wrong letters: %s\n",
                wrongLetters.size(),
                String.join(", ", wrongLetters));

        System.out.print("Guess a letter: ");
    }

    private String guess() {
        Scanner input = new Scanner(System.in);

        return input.next();
    }
}

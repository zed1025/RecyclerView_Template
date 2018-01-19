package inc.thebest.recyclerview_template;

/**
 * Created by amitkumar on 19/01/18 at 21:39.
 */

public class Movie {
    private String title;
    private String genre;
    private String year;

    public Movie(String title, String genre, String year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }


    //getter methods
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    //setter methods
    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(String year) {
        this.year = year;
    }
}

package java8features;

import java.util.*;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
}

class BookRecommendation {
    private String title;
    private double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String getTitle() { return title; }
    public double getRating() { return rating; }

    @Override
    public String toString() {
        return title + " - Rating: " + rating;
    }
}

public class BookRecommendationSystem {

    public static void recommendBooks(List<Book> books, int pageNumber) {       
        List<Book> filteredBooks = books.stream()
            .filter(book -> "Science Fiction".equalsIgnoreCase(book.getGenre()) && book.getRating() > 4.0)
            .collect(Collectors.toList());

        List<BookRecommendation> recommendations = filteredBooks.stream()
            .map(book -> new BookRecommendation(book.getTitle(), book.getRating()))
            .collect(Collectors.toList());

        recommendations.sort((r1, r2) -> Double.compare(r2.getRating(), r1.getRating()));

        int itemsPerPage = 5;
        int startIndex = (pageNumber - 1) * itemsPerPage;
        int endIndex = Math.min(startIndex + itemsPerPage, recommendations.size());

        List<BookRecommendation> paginatedResults = recommendations.subList(startIndex, endIndex);

        System.out.println("Page " + pageNumber + " of Book Recommendations:");
        paginatedResults.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
            new Book("Neuromancer", "William Gibson", "Science Fiction", 4.8),
            new Book("The Martian", "Andy Weir", "Science Fiction", 4.7),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.6),
            new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.2),
            new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.4),
            new Book("1984", "George Orwell", "Dystopian", 4.0),
            new Book("Brave New World", "Aldous Huxley", "Dystopian", 4.1),
            new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction", 4.9),
            new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian", 4.3),
            new Book("The Stars My Destination", "Alfred Bester", "Science Fiction", 4.0),
            new Book("The Moon is a Harsh Mistress", "Robert A. Heinlein", "Science Fiction", 4.6)
        );

        recommendBooks(books, 1);  

        recommendBooks(books, 2);  
    }
}



import java.util.ArrayList;
import java.util.Comparator;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0.0; // Initialize rating to 0
        this.reviews = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear + ", Rating: " + rating;
    }
}
class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();


    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by Author " + author + ": ");
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book.getTitle() + ", Year: " + book.getPublicationYear());
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                System.out.println("Book: " + title + " has been borrowed.");
                return;
            }
        }
        System.out.println("Book: " + title + " is not available in the library.");
    }

    public void returnBook(Book book) {
        books.add(book);
        System.out.println("Book: " + book.getTitle() + " has been returned.");
    }

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0.0; // Return 0 if there are no books in the library
        }

        double totalRating = 0.0;
        for (Book book : books) {
            totalRating += book.getRating();
        }
        return totalRating / books.size();
    }

    public Book getMostReviewedBook() {
        if (books.isEmpty()) {
            return null; // Return null if there are no books in the library
        }

        // Use a comparator to find the book with the highest number of reviews
        return books.stream()
                .max(Comparator.comparingInt(book -> book.getReviews().size()))
                .orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayUsers() {
        System.out.println("\nLibrary Users:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getName() + " (Age: " + users.get(i).getAge() + ")");
        }
    }

    public void borrowBook(String title, User user) {
        if (!isBookAvailable(title)) {
            System.out.println("Book: " + title + " is not available in the library.");
            return;
        }

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                user.borrowBook(book);
                System.out.println("Book: " + title + " has been borrowed by " + user.getName() + ".");
                return;
            }
        }
    }

    public void returnBook(String title, User user) {
        for (Book book : user.getBorrowedBooks()) {
            if (book.getTitle().equals(title)) {
                user.returnBook(book);
                books.add(book);
                System.out.println("Book: " + title + " has been returned by " + user.getName() + ".");
                return;
            }
        }
        System.out.println("Book: " + title + " was not borrowed by " + user.getName() + ".");
    }
}

public class LibraryMain {
    public static void main(String[] args) {
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        System.out.println("\nBorrowing a book:");
        library.borrowBook("Data Structures and Algorithms");
        System.out.println(" ");
        library.displayBooks();

        System.out.println("\nReturning a book:");
        Book returnedBook = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        library.returnBook(returnedBook);
        System.out.println(" ");
        library.displayBooks();

        System.out.println("\nChecking book availability:");
        String titleToCheck = "Data Structures and Algorithms";
        boolean isAvailable = library.isBookAvailable(titleToCheck);
        if (isAvailable) {
            System.out.println("Book: " + titleToCheck + " is available in the library.");
        } else {
            System.out.println("Book: " + titleToCheck + " is not available in the library.");
        }

        User user1 = new User("Agrin", 24);
        User user2 = new User("Pekka", 50);

        library.addUser(user1);
        library.addUser(user2);

        library.displayUsers();

        System.out.println("\nBorrowing a book:");
        library.borrowBook("The Art of Fiction", user1);

        System.out.println("\nReturning a book:");
        library.returnBook("The Art of Fiction", user1);


        // Adding rating and review
        book1.setRating(4.5);
        book1.addReview("Excellent book! ");
        book1.addReview("Highly recommended!");

        System.out.println("\nBook 1 Rating: " + book1.getRating());
        System.out.println("Book 1 Reviews: " + book1.getReviews());

        // Library Statistics
        System.out.println("\nAverage Book Rating in the Library: " + library.getAverageBookRating());

        Book mostReviewedBook = library.getMostReviewedBook();
        if (mostReviewedBook != null) {
            System.out.println("Most Reviewed Book: " + mostReviewedBook.getTitle());
            System.out.println("Number of Reviews: " + mostReviewedBook.getReviews().size());
        } else {
            System.out.println("No books in the library for review comparison.");
        }
    }
}
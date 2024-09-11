package Laibrary;

import Laibrary.model.Book;
import Laibrary.model.LibraryMember;
import Laibrary.system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Hunger Games", "James Willson", "123456");
        Book book2 = new Book("Magical Forest", "Robert Aniston", "789012");

        LibraryMember member1 = new LibraryMember("Jack The Pirate", 1);
        LibraryMember member2 = new LibraryMember("John Wick", 2);

        library.addBook(book1);
        library.addBook(book2);

        library.addMember(member1);
        library.addMember(member2);

        System.out.println(" ");

        library.borrowBook(member1, book1);
        library.returnBook(member1, book1);

        System.out.println(" ");

        library.borrowBook(member2, book2);
        library.returnBook(member2, book2);

        System.out.println(" ");

        library.reserveBook(member1, book2);
        library.reserveBook(member2, book1);
        library.reserveBook(member1, book2);

        System.out.println(" ");

        library.cancelReservation(member1, book2);
        library.cancelReservation(member1, book1);

        System.out.println(" ");

        library.displayReservedBooks(member1);
        library.displayReservedBooks(member2);

        System.out.println(library);
    }
}

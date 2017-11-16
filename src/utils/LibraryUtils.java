package utils;

import data.Book;
import data.Library;
import data.Magazine;
import data.User;

import java.util.Comparator;

public class LibraryUtils {

    public static void printBooks(Library library) {
        printPublications(library, Book.class);
    }

    public static void printMagazines(Library library) {
        printPublications(library, Magazine.class
        );
    }

    private static void printPublications(Library library, Class cl) {
        long countPublications = library.getPublications().values().stream()
                .filter(cl::isInstance)
                .sorted(new Library.AlfabeticalComparator())
                .peek(System.out::println)
                .count();

        if (countPublications == 0 ) {
            System.out.println("W bibliotece nie znaleziono publikacji typu " + cl.getSimpleName());
        }
    }

    public static void printUsers(Library library) {
        library.getUsers().values().stream()
                .sorted(Comparator.comparing(User::getLastName))
                .forEach(System.out::println);
    }

}

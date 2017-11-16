package utils;

import data.Book;
import data.LibraryUser;
import data.Magazine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataReader {
    Scanner sc;

    public DataReader() {
        sc = new Scanner(System.in);
    }

    public Book readAndCreateBook() throws InputMismatchException{
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Autor: ");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Rok wydania: ");
        int year =0;
        int pages = 0;

        try {
            year = sc.nextInt();
            sc.nextLine();
            System.out.println("Ilość stron: ");
            pages = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }

        return new Book(year, title, publisher, author, pages, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("Język: ");
        String language = sc.nextLine();
        System.out.println("Rok wydania: ");
        int year = 0;
        int month = 0;
        int day = 0;

        try {
            year = sc.nextInt();
            sc.nextLine();
            System.out.println("Miesiąc: ");
            month = sc.nextInt();
            sc.nextLine();
            System.out.println("Dzień: ");
            day = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            sc.nextLine();
            throw e;
        }

        return new Magazine(year, title, publisher, month, day, language);
    }

    public LibraryUser readAndCreateLibraryUser() {
        System.out.println("Imię: ");
        String firstName = sc.nextLine();
        System.out.println("Nazwisko: ");
        String lastName = sc.nextLine();
        System.out.println("PESEL: ");
        String pesel = sc.nextLine();

        return new LibraryUser(firstName, lastName, pesel);
    }

    public int getInt() throws NumberFormatException{
        int number = 0;
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            throw new NumberFormatException("Liczba wprowadzona w nieprawidłowej formie");
        } finally {
            sc.nextLine();
        }
        return number;
    }

    public void close() {
        sc.close();
    }
}

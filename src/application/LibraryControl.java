package application;

import data.Book;
import data.Library;
import data.LibraryUser;
import data.Magazine;
import utils.DataReader;
import utils.FileManager;
import utils.LibraryUtils;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class LibraryControl {

    private DataReader dataReader;
    private FileManager fileManager;

    private Library library;

    public LibraryControl() {
        dataReader = new DataReader();
        fileManager = new FileManager();
        try {
            library = fileManager.readLibraryFromFile();
            System.out.println("Wczytano dane biblioteki z pliku");
        } catch (ClassNotFoundException | IOException e) {
            library = new Library();
            System.out.println("Utworzono nową bazę biblioteki.");
        }
    }

    public void controlLoop() {
        Option option = null;

        while ((option != Option.EXIT)) {
            try {
                printOptions();
                option = Option.creatFromInt(dataReader.getInt());
                switch (option) {
                    case ADD_BOOK:
                        addBook();
                        break;
                    case PRINT_BOOKS:
                        printBooks();
                        break;
                    case ADD_MAGAZINE:
                        addMagazine();
                        break;
                    case PRINT_MAGAZINES:
                        printMagazines();
                        break;
                    case ADD_USER:
                        addUser();
                        break;
                    case PRINT_USERS:
                        printUsers();
                        break;
                    case EXIT:
                        exit();
                }
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawne dane, publikacji nie dodano");
            } catch (NumberFormatException | NoSuchElementException e) {
                System.out.println("Wybrana opcja nie istnieje, wybierz ponownie");
            }

        }
        System.out.println("Dziękujemy za skorzystanie z naszej biblioteki");
        dataReader.close();
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        for (Option option: Option.values()){
            System.out.println(option);
        }
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printBooks() {
        LibraryUtils.printBooks(library);
    }

    private void printMagazines() {
        LibraryUtils.printMagazines(library);
    }

    private void addUser() {
        LibraryUser user = dataReader.readAndCreateLibraryUser();
        library.addUser(user);
    }

    private void printUsers() {
        LibraryUtils.printUsers(library);
    }

    private enum  Option {

        EXIT(0,"wyjście z programu"),
        ADD_BOOK(1,"dodanie nowej książki"),
        PRINT_BOOKS(2,"wyświetl dostępne książki"),
        ADD_MAGAZINE(3,"dodanie nowego magazynu"),
        PRINT_MAGAZINES(4,"wyświetl dostępne magazyny"),
        ADD_USER(5, "Dodanie nowego użytkownika"),
        PRINT_USERS(6, "Wyświetlenie listy użytkowników");

        private int value;
        private String description;


        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }


        @Override
        public String toString() {
            return value + " - " + description;
        }

        public static Option creatFromInt(int option) throws NoSuchElementException {
            Option result = null;
            try {
                result = Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException exeption) {
                throw new NoSuchElementException("Brak elementu o wskazanym ID");
            }

            return result;
        }
    }

    private void exit() {
        fileManager.writeLibraryToFile(library);
    }

}

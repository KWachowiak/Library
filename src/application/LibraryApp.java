package application;

public class LibraryApp {
    final static String APP_NAME = "Biblioteka v0.7";

    public static void main(String[] args) {
        LibraryControl libraryControl = new LibraryControl();
        System.out.println(APP_NAME);
        libraryControl.controlLoop();
    }
}

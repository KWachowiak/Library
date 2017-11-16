package data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Library implements Serializable{
    private static final long serialVersionUID = 2995794334600947814L;

    public static final int INITIAL_CAPACITY = 1;

    private Map<String, Publication> publications;
    private Map<String, User> users;

    private int getPublicationNumber() {
        return publications.size();
    }

    public Map<String,Publication> getPublications() {
        return publications;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Library() {
        publications = new HashMap<>();
        users = new HashMap<>();
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    public void addUser(LibraryUser user) {
        users.put(user.getPesel(), user);
    }

    public void removePublication(Publication publication) {
       if (publications.containsValue(publication)) {
           publications.remove(publication.getTitle());
       }
    }

    public void addPublication(Publication publication) {
        publications.put(publication.getTitle(), publication);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Publication p : publications.values()) {
            builder.append(p);
            builder.append("\n");
        }
        return builder.toString();
    }

    public static class AlfabeticalComparator implements Comparator<Publication> {
        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class DateComparator implements Comparator<Publication> {
        @Override
        public int compare(Publication o1, Publication o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }

            Integer i1 = o1.getYear();
            Integer i2 = o2.getYear();

            return -i1.compareTo(i2);
        }
    }


}

package data;

import java.util.ArrayList;
import java.util.List;

public class LibraryUser extends User {
    private static final long serialVersionUID = 1704976407311180890L;

    private List<Publication> publicationHistory;
    private List<Publication> borrowedPublications;

    public LibraryUser(String firstName, String lastName, String pesel) {
        super(firstName, lastName, pesel);
        publicationHistory = new ArrayList<>();
        borrowedPublications = new ArrayList<>();
    }

    public List<Publication> getPublicationHistory() {
        return publicationHistory;
    }

    public List<Publication> getBorrowedPublications() {
        return borrowedPublications;
    }

    private void addPublicationToHistory(Publication publication) {
        publicationHistory.add(publication);
    }

    public void borrowedPublications (Publication publication) {
        borrowedPublications.add(publication);
    }

    public boolean returnPublication(Publication publication) {
        boolean result = false;

        if (borrowedPublications.remove(publication)) {
            result = true;
            addPublicationToHistory(publication);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryUser)) return false;
        if (!super.equals(o)) return false;

        LibraryUser that = (LibraryUser) o;

        if (getPublicationHistory() != null ? !getPublicationHistory().equals(that.getPublicationHistory()) : that.getPublicationHistory() != null)
            return false;
        return getBorrowedPublications() != null ? getBorrowedPublications().equals(that.getBorrowedPublications()) : that.getBorrowedPublications() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getPublicationHistory() != null ? getPublicationHistory().hashCode() : 0);
        result = 31 * result + (getBorrowedPublications() != null ? getBorrowedPublications().hashCode() : 0);
        return result;
    }
}

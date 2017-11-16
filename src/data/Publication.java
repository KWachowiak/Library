package data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Class <code>Publication</code> reperzentuje ogólną publikację
 *
 *
 *
 * @author Klaudiusz Wachowiak
 * @version 1.0.0 15/11/2017
 * @see Publication#hashCode()
 *
 *
 */


public class Publication implements Serializable, Comparable<Publication>{
    private static final long serialVersionUID = 7910452641164094454L;

    private LocalDate date;
    private String title;
    private String publisher;

    public int getYear() {
        return date.getYear();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    protected Publication(int year, String title, String publisher) {
        setDate(LocalDate.of(year, 1, 1));
        this.title = title;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publication that = (Publication) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return publisher != null ? publisher.equals(that.publisher) : that.publisher == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Publication o) {
        return title.compareTo(o.getTitle());
    }
}

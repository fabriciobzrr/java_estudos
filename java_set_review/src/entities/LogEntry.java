package entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class LogEntry implements Comparable<LogEntry> {
    private String user;
    private LocalDateTime date;

    public LogEntry(String user, LocalDateTime date) {
        this.user = user;
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(user, logEntry.user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user);
    }

    @Override
    public int compareTo(LogEntry o) {
        return user.toUpperCase().compareTo(o.user.toUpperCase());
    }
}

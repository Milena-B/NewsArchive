package ru.milena.newsArchive;

import java.time.LocalDateTime;

public interface Archive {
    int getEntriesCount();

    boolean hasEntry(LocalDateTime localDateTime);

    boolean hasEntry(String title);

    String getEntryTitle(LocalDateTime localDateTime);

    String getEntryText(LocalDateTime localDateTime);

    String getEntryText(String title);

    void addEntry(LocalDateTime dateTime, String title, String text);

    void modifyEntryTitle(LocalDateTime localDateTime, String title);

    void modifyEntryText(LocalDateTime localDateTime, String text);

    void removeEntry(LocalDateTime localDateTime);

    void removeEntry(String title);

//    LocalDateTime getEntryDate(String title);

}

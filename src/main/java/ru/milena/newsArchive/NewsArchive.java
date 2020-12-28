package ru.milena.newsArchive;

import java.time.LocalDateTime;
import java.util.HashMap;


public class NewsArchive implements Archive {

    private final HashMap<LocalDateTime, News> newsArchive = new HashMap<>();

    @Override
    public int getEntriesCount() {
        return newsArchive.size();
    }

    @Override
    public boolean hasEntry(LocalDateTime localDateTime) {
        return newsArchive.containsKey(localDateTime);
    }

    @Override
    public boolean hasEntry(String title) {
        for (News news : newsArchive.values()) {
            if (news.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getEntryTitle(LocalDateTime localDateTime) {
        if (newsArchive.containsKey(localDateTime)) {
            return newsArchive.get(localDateTime).getTitle();
        } else throw new ArchiveException("EntryDoesNotExist");
    }

    @Override
    public String getEntryText(LocalDateTime localDateTime) {
        if (newsArchive.containsKey(localDateTime)) {
            return newsArchive.get(localDateTime).getText();
        } else throw new ArchiveException("EntryDoesNotExist");
    }

    @Override
    public String getEntryText(String title) {
        for (News news : newsArchive.values()) {
            if (news.getTitle().equals(title)) {
                return news.getText();
            }
        }
        throw new ArchiveException("EntryDoesNotExist");
    }

    @Override
    public void addEntry(LocalDateTime localDateTime, String title, String text) {
        if (title != null && text != null) {
            newsArchive.put(localDateTime, new News(title, text));
        }
        if (title == null) {
            throw new ArchiveException("EmptyEntryTitle");
        }
        if (text == null) {
            throw new ArchiveException("EmptyEntryTex");
        }
        if (title.equals(getEntryTitle(localDateTime))) {
            throw new ArchiveException("DuplicatedEntry");
        }
    }

    @Override
    public void modifyEntryTitle(LocalDateTime localDateTime, String title) {
        if (newsArchive.containsKey(localDateTime) && title != null) {
            newsArchive.get(localDateTime).setTitle(title);
        }
        if (title == null) {
            throw new ArchiveException("EmptyEntryTitle");
        }
        throw new ArchiveException("EntryDoesNotExist");
    }

    @Override
    public void modifyEntryText(LocalDateTime localDateTime, String text) {
        if (newsArchive.containsKey(localDateTime) && text != null) {
            newsArchive.get(localDateTime).setText(text);
        }
        if (text == null) {
            throw new ArchiveException("EmptyEntryText");
        }
        throw new ArchiveException("EntryDoesNotExist");
    }

    @Override
    public void removeEntry(LocalDateTime localDateTime) {
        newsArchive.remove(localDateTime);
    }

    @Override
    public void removeEntry(String title) {
        for (News news : newsArchive.values()) {
            if (news.getTitle().equals(title)) {
                removeEntry(title);
            }
        }
        throw new ArchiveException("EntryDoesNotExist");
    }

    //    @Override
//    public LocalDateTime getEntryDate(String title) {
//       for(Map.Entry<LocalDateTime,News>entry : newsArchive.entrySet()){
//             LocalDateTime key = entry.getKey();
//             News value = entry.getValue();
//              if(value.equals())
//
//        }
//        throw new ArchiveException("EntryDoesNotExist");
//    }

}

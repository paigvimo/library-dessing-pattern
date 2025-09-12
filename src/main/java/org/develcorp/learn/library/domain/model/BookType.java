package org.develcorp.learn.library.domain.model;

/**
 * Enum representing the different types of books.
 * This enum is used to categorize books as either fiction or non-fiction.
 */
public enum BookType {
    FICTION("Fiction"),
    NON_FICTION("Non-fiction");

    private final String displayName;

    BookType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
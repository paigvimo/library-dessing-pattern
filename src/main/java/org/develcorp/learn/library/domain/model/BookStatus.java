package org.develcorp.learn.library.domain.model;

/**
 * Enum representing the availability status of books.
 * This enum is used to track whether a book is available for borrowing or is currently borrowed.
 */
public enum BookStatus {
    AVAILABLE("Available"),
    BORROWED("Borrowed");

    private final String displayName;

    BookStatus(String displayName) {
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
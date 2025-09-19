package org.develcorp.learn.library.domain.model.entity.enums;

/**
 * Enum representing the format of books.
 * This enum is used to distinguish between physical and digital books.
 */
public enum BookFormat {
    PHYSICAL("Physical"),
    DIGITAL("Digital");

    private final String displayName;

    BookFormat(String displayName) {
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
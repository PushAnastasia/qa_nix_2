package ua.com.alevel.model;

public enum ExtensionType {

    TXT("txt");

    private final String extension;

    ExtensionType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}

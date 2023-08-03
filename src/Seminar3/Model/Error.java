package Seminar3.Model;

public enum Error {
    DATABASE(0, "Error when filling in the data. Incorrect quantity.");

    private final int code;
    private final String description;

    Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Error code " + code +
                ": " + description;
    }
}

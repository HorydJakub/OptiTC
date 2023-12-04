package enumerates;

public enum SupportedDatabases {

    MYSQL("MySQL");

    private final String name;

    SupportedDatabases(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

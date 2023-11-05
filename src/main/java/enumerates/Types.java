package enumerates;

public enum Types {

    FUNCTIONAL("Functional"),
    NON_FUNCTIONAL("Non-functional"),
    SMOKE("Smoke"),
    USABILITY("Usability"),
    GUI("GUI"),
    SECURITY("Security");

    private final String type;

    Types(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

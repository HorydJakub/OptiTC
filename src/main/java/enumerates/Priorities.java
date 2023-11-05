package enumerates;

public enum Priorities {
    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    CRITICAL("Critical");

    private final String priority;
    Priorities(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}

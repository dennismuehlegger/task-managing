package TaskManaging;

public enum TaskInputEnums {
    YES("yes"),
    TITLE("title"),
    PRIORITY("priority"),
    STATUS("status"),
    DEADLINE("deadline"),
    ASC("asc"),
    DESC("desc");

    public final String value;

    TaskInputEnums(String value) {
        this.value = value;
    }
}

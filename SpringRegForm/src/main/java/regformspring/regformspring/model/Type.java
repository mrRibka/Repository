package regformspring.regformspring.model;

public enum Type {
    JSON("JSON"),
    XML("XML");
    private String name;

    Type(String name) {
        this.name = name;
    }
}

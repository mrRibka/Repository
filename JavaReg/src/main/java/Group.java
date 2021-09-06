public enum Group {
    FIRST_GROUP("first"),
    SECOND_GROUP("second"),
    THIRD_GROUP("third"),
    DEFAULT("no group");

    private String group;

    Group(String group) {
        this.group = group;
    }
    public String getGroup(){
        return group;
    }
}

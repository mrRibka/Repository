public enum DataBaseUser {
    USER_ONE ("Egor"),
    USER_TWO("Taras");

    private final String login;

    DataBaseUser(String login) {
        this.login = login;
    }
    public static boolean checkLogin(String dataLogin){
        for (DataBaseUser note : DataBaseUser.values()){
            if (note.login.equals(dataLogin))
                return true;
        }
        return false;
    }
}

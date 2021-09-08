import java.io.NotActiveException;

public class User {
    private String first_name;
    private String last_name;
    private String patronymic;
    private String nick;
    private String comment;
    private Group group;
    private String mobPhone;
    private String e_mail;
    private String skype;
    private String full_name;
    private String login;

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setLogin(String login)throws NotUniqueLoginException {
        if (DataBaseUser.checkLogin(login)) {
            throw new NotUniqueLoginException
                    ("Not unique login: ", login);
        }
        this.login = login;
    }
    User(){
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }
}

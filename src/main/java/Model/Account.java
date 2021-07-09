package Model;

import Common.Common.Utilities;

public class Account {
    private String EMAIL;
    private String PASSWORD;
    private String PID_PASSPORT;

    public Account() {
        this.EMAIL = "NLNQuang-" + Utilities.getRandomString(10) + "@gmail.com";
        this.PASSWORD = Utilities.getRandomString(10);
        this.PID_PASSPORT = Utilities.getRandomString(9);
    }


    public String getEmail() {
        return this.EMAIL;
    }

    public String getPassword() {
        return this.PASSWORD;
    }

    public String getPID() {
        return this.PID_PASSPORT;
    }


}

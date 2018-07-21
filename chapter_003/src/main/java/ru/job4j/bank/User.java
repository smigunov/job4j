package ru.job4j.bank;

public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }

    public String getPassport() {
        return this.passport;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof User) {
                User usrObj = (User) obj;
                if (this.name.equals(usrObj.getName()) && this.passport.equals(usrObj.getPassport())) {
                    result = true;
                }
            }
        }
        return result;
    }


}

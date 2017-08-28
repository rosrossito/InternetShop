package inetShop.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 01.08.2017.
 */
public class Validator {

    private String login;
    private String password;
    private String name;
    private String region;
    private String feedback;
    private String gender;
    private String retypepsw;
    private String agree;

    private List<String> loginMessage;
    private List<String> passwordMessage;
    private List<String> nameMessage;
    private List<String> regionMessage;
    private List<String> feedbackMessage;
    private List<String> genderMessage;
    private List<String> retypepswMessage;
    private List<String> agreeMessage;

    public Validator() {
    }

    public Validator(String login, String password, String name, String region, String feedback, String gender, String retypepsw, String agree) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.region = region;
        this.feedback = feedback;
        this.gender = gender;
        this.retypepsw = retypepsw;
        this.agree = agree;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRetypepsw(String retypepsw) {
        this.retypepsw = retypepsw;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public void setLoginMessage(List<String> loginMessage) {
        this.loginMessage = loginMessage;
    }

    public void setPasswordMessage(List<String> passwordMessage) {
        this.passwordMessage = passwordMessage;
    }

    public void setNameMessage(List<String> nameMessage) {
        this.nameMessage = nameMessage;
    }

    public void setRegionMessage(List<String> regionMessage) {
        this.regionMessage = regionMessage;
    }

    public void setFeedbackMessage(List<String> feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public void setGenderMessage(List<String> genderMessage) {
        this.genderMessage = genderMessage;
    }

    public void setRetypepswMessage(List<String> retypepswMessage) {
        this.retypepswMessage = retypepswMessage;
    }

    public void setAgreeMessage(List<String> agreeMessage) {
        this.agreeMessage = agreeMessage;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getGender() {
        return gender;
    }

    public String getRetypepsw() {
        return retypepsw;
    }

    public String getAgree() {
        return agree;
    }


    public List<String> getLoginMessage() {
        loginMessage = new ArrayList<String>();
        String regexMail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (login.equals("")) {
            loginMessage.add("Empty Login");
        }

        if (!login.matches(regexMail)) {
            loginMessage.add("E-mail is not valid");
        }

        return loginMessage;
    }

    public List<String> getPasswordMessage() {
        passwordMessage = new ArrayList<String>();
        String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
        if (!password.matches(regexPassword)) {
            passwordMessage.add("Password must start of string, contain at least one digit, lower case and " +
                    "upper case letter, " +
                    "at least 8 symbols and no whitespace allowed");
        }

        if (password.equals("")) {
            passwordMessage.add("");
        }

        return passwordMessage;
    }


    public List<String> getNameMessage() {
        nameMessage = new ArrayList<String>();
        if (name.equals("")) {
            nameMessage.add("Empty Name");
        }
        return nameMessage;
    }

    public List<String> getRegionMessage() {
        return regionMessage;
    }

    public List<String> getFeedbackMessage() {
        return feedbackMessage;
    }

    public List<String> getGenderMessage() {
        genderMessage = new ArrayList<String>();
        if (gender==null) {
            //if (gender.equals("")) {
                genderMessage.add("Please, indicate your sex");
            //}
        }
        return genderMessage;
    }

    public List<String> getRetypepswMessage() {
        retypepswMessage = new ArrayList<String>();
        if (!password.equals(retypepsw)) {
            retypepswMessage.add("Passwords do not match");
        }

        return retypepswMessage;
    }

    public List<String> getAgreeMessage() {
        agreeMessage = new ArrayList<String>();
        if (agree==null) {
//        if (agree.equals("")) {
            agreeMessage.add("You did not accept agreement conditions");
        }
        return agreeMessage;
    }

    public boolean isValidLogin() {
        return getLoginMessage().isEmpty();
    }

    public boolean isValid() {
        return getLoginMessage().isEmpty()
                && getAgreeMessage().isEmpty()
                && getGenderMessage().isEmpty()
                && getNameMessage().isEmpty()
                && getPasswordMessage().isEmpty()
                && getRetypepswMessage().isEmpty();
    }
}

package in.anandm.oj.command;

public class RegistrationCommand {

    private String emailId;

    private String password;

    private String repeatPassword;

    /**
     * 
     */
    public RegistrationCommand() {
        super();

    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

}

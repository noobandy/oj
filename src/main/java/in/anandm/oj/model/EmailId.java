package in.anandm.oj.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmailId implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */

    @Column(name = "email_id")
    private String emailId;

    private static final transient Pattern pattern;
    static {
        pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    /**
     * 
     */
    EmailId() {
        super();

    }

    private EmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * 
     * @methodName:EmailId.java.createEmailId
     * @description: factory to create valid EmailId
     * @author anandm
     * @returnType EmailId
     * @param emailId
     * @return new {@link EmailId} instance if {@link #emailId} is valid else
     *         returns <code>null</code>
     */
    public static final EmailId createEmailId(String emailId) {
        if (isValidEmailId(emailId)) {
            return new EmailId(emailId);
        }

        return null;
    }

    private static final boolean isValidEmailId(String emailId) {
        Matcher matcher = pattern.matcher(emailId);

        return matcher.matches();
    }

    public String getEmailId() {
        return emailId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EmailId other = (EmailId) obj;
        if (emailId == null) {
            if (other.emailId != null) {
                return false;
            }
        }
        else if (!emailId.equals(other.emailId)) {
            return false;
        }
        return true;
    }

}

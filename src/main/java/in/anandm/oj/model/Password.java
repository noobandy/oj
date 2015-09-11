/**
 * @filenameName:in.anandm.todo.model.Password.java
 * @description:TODO
 * @author anandm
 * @date Aug 13, 2015 11:06:02 AM
 * @version: TODO
 */
package in.anandm.oj.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @className:in.anandm.todo.model.Password.java
 * @description:TODO
 * @author anandm
 * @date Aug 13, 2015 11:06:02 AM
 */
@Embeddable
public class Password {

    @Column(name = "password")
    private String password;

    private static final transient Pattern PATTERN;

    static {
        PATTERN = Pattern
                .compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*(_|[!@#$%\\^&\\*])).+$");
    }

    /**
     * 
     */
    private Password() {
        super();

    }

    /**
     * @param password
     */
    private Password(String password) {
        super();
        this.password = password;
    }

    /**
     * 
     * @methodName:Password.java.createPassword
     * @description: factory to create a new {@link Password} instance
     * @author anandm
     * @returnType Password
     * @param plainTextPassword
     * @return newly created {@link Password} instance if plainTextPassword is
     *         valid else return <code>null</code>
     */
    public static final Password createPassword(String plainTextPassword) {
        if (isValid(plainTextPassword)) {
            return new Password(hash(plainTextPassword));
        }

        return null;
    }

    /**
     * @methodName:Password.java.hash
     * @description:TODO
     * @author anandm
     * @returnType String
     * @param plainTextPassword
     * @return
     */
    private static String hash(String plainTextPassword) {

        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    /**
     * @methodName:Password.java.isValid
     * @description:TODO
     * @author anandm
     * @returnType boolean
     * @param plainTextPassword
     * @return
     */
    private static boolean isValid(String plainTextPassword) {
        Matcher matcher = PATTERN.matcher(plainTextPassword);
        return plainTextPassword.length() > 6 && matcher.matches();
    }

    public boolean matches(String plainTextPassword) {
        return BCrypt.checkpw(plainTextPassword, password);
    }

    public String getPassword() {
        return password;
    }

}

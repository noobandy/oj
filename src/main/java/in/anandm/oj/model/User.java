package in.anandm.oj.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User {

    @EmbeddedId
    private EmailId emailId;

    @Embedded
    private Password password;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "verified_at")
    private Date verifiedAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "locked_at")
    private Date lockedAt;

    @Column(name = "verification_key")
    private String verificationKey;

    @Column(name = "password_reset_key")
    private String passwordResetKey;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(
            name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles = new HashSet<Role>();

    /**
     * 
     */
    private User() {
        super();

    }

    /**
     * @param emailId
     * @param password
     * @param verificationKey
     */
    private User(EmailId emailId, Password password, String verificationKey) {
        super();
        this.emailId = emailId;
        this.password = password;
        this.verificationKey = verificationKey;
        this.createdAt = new Date();
    }

    public static final User createUser(EmailId emailId, Password password) {
        String verificationKey = randomKey();

        return new User(emailId, password, verificationKey);
    }

    public boolean verify(String key) {
        if (verificationKey.equals(key)) {
            verifiedAt = new Date();
            return true;
        }

        return false;
    }

    public String requestPasswordReset() {
        if (passwordResetKey == null) {
            passwordResetKey = randomKey();
        }

        return passwordResetKey;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        boolean changed = false;
        if (password.matches(oldPassword)) {
            Password newPasswordObj = Password.createPassword(newPassword);
            if (newPasswordObj != null) {
                password = newPasswordObj;
                changed = true;
            }
        }

        return changed;

    }

    public boolean resetPassword(String resetKey, String newPassword) {
        boolean changed = false;
        if (resetKey.equals(passwordResetKey)) {
            Password newPasswordObj = Password.createPassword(newPassword);
            if (newPasswordObj != null) {
                password = newPasswordObj;
                changed = true;
            }
        }
        return changed;
    }

    private static final String randomKey() {
        return UUID.randomUUID().toString();
    }

    public void grantRole(Role role) {
        roles.add(role);
    }

    public void revokeRole(Role role) {
        roles.remove(role);
    }

    public String getVerificationKey() {
        return verificationKey;
    }

    public Password getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public boolean isLocked() {
        return !(lockedAt == null);
    }

    public boolean isEnabled() {
        return !(verifiedAt == null);
    }
}

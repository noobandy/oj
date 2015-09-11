package in.anandm.oj.repository;

import in.anandm.oj.model.EmailId;
import in.anandm.oj.model.User;

import org.springframework.transaction.annotation.Transactional;

public interface UserRepository {

    @Transactional
    User saveUser(User user);

    @Transactional
    User getUserByEmailId(EmailId emailId);
}

package in.anandm.oj.service.impl;

import in.anandm.oj.command.RegistrationCommand;
import in.anandm.oj.model.EmailId;
import in.anandm.oj.model.Password;
import in.anandm.oj.model.Role;
import in.anandm.oj.model.User;
import in.anandm.oj.repository.UserRepository;
import in.anandm.oj.service.UserService;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    /**
     * @param userRepository
     */
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(RegistrationCommand registrationCommand) {
        EmailId emailId = EmailId.createEmailId(registrationCommand
                .getEmailId());
        Password password = Password.createPassword(registrationCommand
                .getPassword());

        User user = User.createUser(emailId, password);

        user.verify(user.getVerificationKey());

        user.grantRole(Role.USER_ROLE);

        userRepository.saveUser(user);
    }

}

package in.anandm.oj.service;

import in.anandm.oj.command.RegistrationCommand;

public interface UserService {

    void registerUser(RegistrationCommand registrationCommand);
}

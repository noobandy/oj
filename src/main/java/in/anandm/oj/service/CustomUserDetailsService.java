package in.anandm.oj.service;

import in.anandm.oj.model.EmailId;
import in.anandm.oj.model.Role;
import in.anandm.oj.model.User;
import in.anandm.oj.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    /**
     * @param userRepository
     */
    public CustomUserDetailsService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.getUserByEmailId(EmailId
                .createEmailId(username));
        if (user == null) {
            throw new UsernameNotFoundException("user not found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                username, user.getPassword().getPassword(), user.isEnabled(),
                true, true, !user.isLocked(), authorities);
        return userDetails;
    }
}

package week4_hw2.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import week4_hw2.domain.User;
import week4_hw2.repository.UserRepository;
import week4_hw2.security.factory.JwtUserFactory;
import week4_hw2.security.pojo.JwtUser;

public class JwtUserDetailsServer implements UserDetailsService {

    private final UserRepository userRepository;

    public JwtUserDetailsServer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            JwtUser jwtUser = JwtUserFactory.create(user);
            return jwtUser;
        }
    }
}

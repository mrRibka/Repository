package regformspring.regformspring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import regformspring.regformspring.model.User;
import regformspring.regformspring.repository.UserRepository;

import java.util.Optional;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return SecurityUser.fromUser(userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User does not exist")));
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public void save(User user){
        userRepository.save(user);
    }
}

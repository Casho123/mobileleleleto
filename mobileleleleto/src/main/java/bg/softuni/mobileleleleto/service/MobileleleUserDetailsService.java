package bg.softuni.mobileleleleto.service;


import bg.softuni.mobileleleleto.models.entity.UserEntity;
import bg.softuni.mobileleleleto.models.entity.UserRoleEntity;
import bg.softuni.mobileleleleto.models.user.MobileleUserDetails;
import bg.softuni.mobileleleleto.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MobileleleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MobileleleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return this.userRepository.findByEmail(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with " + username + " not found!"));
    }

    private UserDetails map(UserEntity userEntity) {

        return new MobileleUserDetails(
                userEntity.getPassword(),
                userEntity.getEmail(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getUserRoles()
                        .stream().map(this::map)
                        .toList()
        );
    }


    private GrantedAuthority map(UserRoleEntity userRole) {
        return new SimpleGrantedAuthority("ROLE_" +
                userRole.getUserRole().name());
    }
}

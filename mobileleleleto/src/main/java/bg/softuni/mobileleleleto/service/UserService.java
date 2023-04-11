package bg.softuni.mobileleleleto.service;

import bg.softuni.mobileleleleto.models.dto.UserLoginDTO;
import bg.softuni.mobileleleleto.models.dto.UserRegistrationDTO;
import bg.softuni.mobileleleleto.models.entity.UserEntity;
import bg.softuni.mobileleleleto.models.mapper.UserMapper;
import bg.softuni.mobileleleleto.repository.UserRepository;
import bg.softuni.mobileleleleto.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private CurrentUser currentUser;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;



    public UserService(UserRepository userRepository, CurrentUser currentUser, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerAndLogin(UserRegistrationDTO userRegistrationDTO) {
        UserEntity newUser = this.userMapper.userDTOtoUserEntity(userRegistrationDTO);
        newUser.setPassword(passwordEncoder.encode(userRegistrationDTO.getConfirmPassword()));
        this.userRepository.save(newUser);
        login(newUser);
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOpt = this.userRepository.findByEmail(userLoginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.debug("User with name [{}] not found.", userLoginDTO.getUsername());
            return false;
        }
        String rawPassword = userLoginDTO.getPassword();
        String encryptedPassword= userOpt.get().getPassword();

        boolean success = passwordEncoder.matches(rawPassword, encryptedPassword);

        if (success) {
            login((userOpt.get()));
        } else {
            logout();

        }

        return success;
    }

    private void login(UserEntity userEntity) {
        currentUser.setLoggedIn(true);
        currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
        currentUser.setEmail(userEntity.getEmail());
    }

    public void logout() {
        this.currentUser.clear();
    }

}

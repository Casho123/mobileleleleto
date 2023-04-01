package bg.softuni.mobileleleleto.service;

import bg.softuni.mobileleleleto.models.dto.UserLoginDTO;
import bg.softuni.mobileleleleto.models.entity.UserEntity;
import bg.softuni.mobileleleleto.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;



    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<UserEntity> userOpt = this.userRepository.findByEmail(userLoginDTO.getUsername());

        if (userOpt.isEmpty()) {
            LOGGER.debug("User with name [{}] not found.", userLoginDTO.getUsername());
            return false;
        }
        return userOpt.get().getPassword().equals(userLoginDTO.getPassword());

    }
}

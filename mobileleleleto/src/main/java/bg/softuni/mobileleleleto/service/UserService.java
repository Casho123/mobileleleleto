package bg.softuni.mobileleleleto.service;

import bg.softuni.mobileleleleto.models.dto.UserLoginDTO;
import bg.softuni.mobileleleleto.models.dto.UserRegistrationDTO;
import bg.softuni.mobileleleleto.models.entity.UserEntity;
import bg.softuni.mobileleleleto.models.mapper.UserMapper;
import bg.softuni.mobileleleleto.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;



    public UserService(UserRepository userRepository,  UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerAndLogin(UserRegistrationDTO userRegistrationDTO) {
        UserEntity newUser = this.userMapper.userDTOtoUserEntity(userRegistrationDTO);
        newUser.setPassword(passwordEncoder.encode(userRegistrationDTO.getConfirmPassword()));
        this.userRepository.save(newUser);
        login(newUser);
    }



    private void login(UserEntity userEntity) {
        //TODO
    }


}

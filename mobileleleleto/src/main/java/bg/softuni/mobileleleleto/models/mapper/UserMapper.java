package bg.softuni.mobileleleleto.models.mapper;

import bg.softuni.mobileleleleto.models.dto.UserRegistrationDTO;
import bg.softuni.mobileleleleto.models.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active", constant = "true")
    UserEntity userDTOtoUserEntity(UserRegistrationDTO userRegistrationDTO);


}

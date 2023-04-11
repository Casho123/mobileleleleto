package bg.softuni.mobileleleleto.models.mapper;

import bg.softuni.mobileleleleto.models.dto.AddOfferDTO;
import bg.softuni.mobileleleleto.models.entity.OfferEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);
}

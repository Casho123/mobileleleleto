package bg.softuni.mobileleleleto.service;

import bg.softuni.mobileleleleto.models.dto.AddOfferDTO;
import bg.softuni.mobileleleleto.models.entity.ModelEntity;
import bg.softuni.mobileleleleto.models.entity.OfferEntity;
import bg.softuni.mobileleleleto.models.entity.UserEntity;
import bg.softuni.mobileleleleto.models.mapper.OfferMapper;
import bg.softuni.mobileleleleto.repository.ModelRepository;
import bg.softuni.mobileleleleto.repository.OfferRepository;
import bg.softuni.mobileleleleto.repository.UserRepository;
import bg.softuni.mobileleleleto.user.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    private final ModelRepository modelRepository;
    private final OfferMapper offerMapper;

    private final UserRepository userRepository;

    private CurrentUser currentUser;

    public OfferService(OfferRepository offerRepository, ModelRepository modelRepository, OfferMapper offerMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelRepository = modelRepository;
        this.offerMapper = offerMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    public void addOffer(AddOfferDTO addOfferDTO) {

        OfferEntity newOffer = offerMapper.addOfferDtoToOfferEntity(addOfferDTO);


        //TODO - current user should be logged in

        UserEntity seller = this.userRepository.findByEmail(currentUser.getEmail())
                .orElseThrow();
        ModelEntity model = this.modelRepository.findById(addOfferDTO.getModelId())
                .orElseThrow();
        newOffer.setModel(model);
        newOffer.setSeller(seller);

        this.offerRepository.save(newOffer);
    }
}

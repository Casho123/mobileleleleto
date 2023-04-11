package bg.softuni.mobileleleleto.service;

import bg.softuni.mobileleleleto.models.dto.BrandDTO;
import bg.softuni.mobileleleleto.models.dto.ModelDTO;
import bg.softuni.mobileleleleto.models.entity.BrandEntity;
import bg.softuni.mobileleleleto.models.entity.ModelEntity;
import bg.softuni.mobileleleleto.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    public List<BrandDTO> getAllBrands() {
        return this.brandRepository.findAll()
                .stream()
                .map(this::mapBrand)
                .collect(Collectors.toList());

    }

    private BrandDTO mapBrand(BrandEntity brandEntity) {
        List<ModelDTO> models = brandEntity
                .getModels()
                .stream()
                .map(this::mapModel).collect(Collectors.toList());

        BrandDTO result = new BrandDTO();
        result.setModels(models);
        result.setName(brandEntity.getName());
        return result;

    }

    private ModelDTO mapModel(ModelEntity modelEntity) {

        ModelDTO model = new ModelDTO();
        model.setId(modelEntity.getId());
        model.setName(modelEntity.getName());

        return model;

    }

}

package bg.softuni.mobileleleleto.models.dto;

import bg.softuni.mobileleleleto.models.enums.EngineEnum;

import javax.validation.constraints.NotNull;

public class AddOfferDTO {
    @NotNull
    private EngineEnum engine;

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }
}

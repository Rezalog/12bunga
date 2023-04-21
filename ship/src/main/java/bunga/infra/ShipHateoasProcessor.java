package bunga.infra;

import bunga.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ShipHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Ship>> {

    @Override
    public EntityModel<Ship> process(EntityModel<Ship> model) {
        return model;
    }
}

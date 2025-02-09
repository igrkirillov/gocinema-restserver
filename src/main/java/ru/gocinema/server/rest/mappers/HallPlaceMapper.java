package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.gocinema.restapi.model.HallPlace;
import ru.gocinema.restapi.model.HallPlaceParameters;

@Mapper(componentModel = "spring")
public interface HallPlaceMapper {

    HallPlace map(ru.gocinema.server.model.HallPlace source);

    List<HallPlace> map(Iterable<ru.gocinema.server.model.HallPlace> source);

    ru.gocinema.server.model.HallPlace map(HallPlaceParameters parameters);

    @InheritInverseConfiguration
    void fromDto(HallPlaceParameters parameters, @MappingTarget ru.gocinema.server.model.HallPlace entity);
}

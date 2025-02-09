package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallParameters;

@Mapper(componentModel = "spring", uses = HallPlaceMapper.class)
public interface HallMapper {

    Hall map(ru.gocinema.server.model.Hall source);

    List<Hall> map(Iterable<ru.gocinema.server.model.Hall> source);

    ru.gocinema.server.model.Hall map(HallParameters parameters);

    @InheritInverseConfiguration
    void fromDto(HallParameters parameters, @MappingTarget ru.gocinema.server.model.Hall entity);
}

package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.apache.commons.lang3.BooleanUtils;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.gocinema.restapi.model.HallPlace;
import ru.gocinema.restapi.model.HallPlaceParameters;

@Mapper(componentModel = "spring", imports = BooleanUtils.class)
public interface HallPlaceMapper {

    @Mapping(target = "isBlocked", expression = "java(source.isBlocked())")
    @Mapping(target = "isVip", expression = "java(source.isVip())")
    HallPlace map(ru.gocinema.server.model.HallPlace source);

    List<HallPlace> map(Iterable<ru.gocinema.server.model.HallPlace> source);

    ru.gocinema.server.model.HallPlace map(HallPlaceParameters parameters);

    @InheritInverseConfiguration
    void fromDto(HallPlaceParameters parameters, @MappingTarget ru.gocinema.server.model.HallPlace entity);

    @AfterMapping
    default void fromDtoPost(HallPlaceParameters parameters, @MappingTarget ru.gocinema.server.model.HallPlace entity) {
        entity.setBlocked(BooleanUtils.isTrue(parameters.getIsBlocked()));
        entity.setVip(BooleanUtils.isTrue(parameters.getIsVip()));
    }
}

package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.gocinema.restapi.model.Ticket;

@Mapper(componentModel = "spring", uses = BookedPlaceMapper.class)
public interface TicketsMapper {
    @Mapping(target = "isPayed", expression = "java(source.isPayed())")
    Ticket map(ru.gocinema.server.model.Ticket source);
    List<Ticket> map(Iterable<ru.gocinema.server.model.Ticket> source);
}

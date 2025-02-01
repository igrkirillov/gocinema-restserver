package ru.gocinema.server.rest.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import ru.gocinema.restapi.model.Ticket;

@Mapper(componentModel = "spring")
public interface TicketsMapper {
    Ticket map(ru.gocinema.server.model.Ticket source);
    List<Ticket> map(Iterable<ru.gocinema.server.model.Ticket> source);
}

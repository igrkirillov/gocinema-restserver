package ru.gocinema.server.rest.services;

import java.util.List;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallParameters;

public interface HallService {
    List<Hall> getAll();
    Hall save(HallParameters parameters);
    void update(int id, HallParameters parameters);
    void delete(int id);
}

package ru.gocinema.server.rest.services;

import java.util.List;
import ru.gocinema.restapi.model.HallPlace;
import ru.gocinema.restapi.model.HallPlaceParameters;

public interface HallPlaceService {
    List<HallPlace> getHallPlaces(Integer hallId);
    void updateHallPlace(int id, HallPlaceParameters parameters);
}

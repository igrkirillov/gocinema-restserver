package ru.gocinema.server.rest.services;

import java.util.List;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallConfigurationParameters;
import ru.gocinema.restapi.model.HallPricesParameters;

public interface HallService {
    List<Hall> getAll();
    Hall save(HallConfigurationParameters parameters);
    void updateConfiguration(int id, HallConfigurationParameters parameters);
    void updatePrices(int id, HallPricesParameters parameters);
    void delete(int id);
}

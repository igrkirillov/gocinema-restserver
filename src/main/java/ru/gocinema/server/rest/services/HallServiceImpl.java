package ru.gocinema.server.rest.services;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallParameters;
import ru.gocinema.server.model.HallPlace;
import ru.gocinema.server.repositories.HallPlaceRepository;
import ru.gocinema.server.repositories.HallRepository;
import ru.gocinema.server.rest.mappers.HallMapper;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;
    private final HallPlaceRepository hallPlaceRepository;
    private final HallMapper hallMapper;

    @Override
    public List<Hall> getAll() {
        return hallMapper.map(hallRepository.findAll());
    }

    @Transactional
    @Override
    public Hall save(HallParameters parameters) {
        var hall = hallRepository.save(hallMapper.map(parameters));
        createPlaces(hall);
        return hallMapper.map(hall);
    }

    @Transactional
    @Override
    public void update(int id, HallParameters parameters) {
        var hall = hallRepository.findById(id).orElseThrow();
        clearAllPlaces(hall);
        createPlaces(hall);
        hall.setName(parameters.getName());
        hall.setCols(parameters.getCols());
        hall.setRows(parameters.getRows());
        hallRepository.save(hall);
    }

    private void clearAllPlaces(ru.gocinema.server.model.Hall hall) {
        hallPlaceRepository.deleteAllByHallId(hall.getId());
    }

    private void createPlaces(ru.gocinema.server.model.Hall hall) {
        List<HallPlace> places = new ArrayList<>();
        for (int x = 0; x < hall.getCols(); ++x) {
            for (int y = 0; y < hall.getRows(); ++y) {
                HallPlace place = new HallPlace();
                place.setHall(hall);
                place.setCol(x);
                place.setRow(y);
                places.add(place);
            }
        }
        hallPlaceRepository.saveAll(places);
    }
}

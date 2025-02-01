package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.HallPlace;
import ru.gocinema.restapi.model.HallPlaceParameters;
import ru.gocinema.server.repositories.HallPlaceRepository;
import ru.gocinema.server.rest.mappers.HallPlaceMapper;

@Service
@RequiredArgsConstructor
public class HallPlaceServiceImpl implements HallPlaceService {

    private final HallPlaceRepository hallPlaceRepository;
    private final HallPlaceMapper hallPlaceMapper;

    @Override
    public List<HallPlace> getHallPlaces(Integer hallId) {
        return hallPlaceMapper.map(hallPlaceRepository.findByParameters(hallId));
    }

    @Transactional
    @Override
    public void updateHallPlace(int id, HallPlaceParameters parameters) {
        ru.gocinema.server.model.HallPlace place = hallPlaceRepository.findById(id).orElseThrow();
        place.setVip(BooleanUtils.isTrue(parameters.getIsVip()));
        hallPlaceRepository.save(place);
    }
}

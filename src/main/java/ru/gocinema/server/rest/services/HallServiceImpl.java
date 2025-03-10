package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallConfigurationParameters;
import ru.gocinema.restapi.model.HallPricesParameters;
import ru.gocinema.server.repositories.HallRepository;
import ru.gocinema.server.repositories.MovieShowRepository;
import ru.gocinema.server.rest.mappers.HallMapper;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;
    private final HallMapper hallMapper;
    private final MovieShowRepository movieShowRepository;

    private static final int DEFAULT_STANDARD_PRICE = 50;
    private static final int DEFAULT_VIP_PRICE = 100;

    @Override
    public List<Hall> getAll() {
        return hallMapper.map(hallRepository.findAll());
    }

    @Transactional
    @Override
    public Hall save(HallConfigurationParameters parameters) {
        var hall = hallMapper.map(parameters);
        hall.setStandardPrice(DEFAULT_STANDARD_PRICE);
        hall.setVipPrice(DEFAULT_VIP_PRICE);
        return hallMapper.map(hallRepository.save(hall));
    }

    @Transactional
    @Override
    public void updateConfiguration(int id, HallConfigurationParameters parameters) {
        var hall = hallRepository.findById(id).orElseThrow();
        hallMapper.fromDto(parameters, hall);
        hallRepository.save(hall);
    }

    @Transactional
    @Override
    public void updatePrices(int id, HallPricesParameters parameters) {
        var hall = hallRepository.findById(id).orElseThrow();
        hallMapper.fromDto(parameters, hall);
        hallRepository.save(hall);
    }

    @Transactional
    @Override
    public void delete(int id) {
        movieShowRepository.deleteByHallId(id);
        hallRepository.deleteById(id);
    }
}

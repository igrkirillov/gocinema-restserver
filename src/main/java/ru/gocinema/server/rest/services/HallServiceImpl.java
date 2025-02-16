package ru.gocinema.server.rest.services;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.Hall;
import ru.gocinema.restapi.model.HallParameters;
import ru.gocinema.server.repositories.HallRepository;
import ru.gocinema.server.rest.mappers.HallMapper;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {

    private final HallRepository hallRepository;
    private final HallMapper hallMapper;

    @Override
    public List<Hall> getAll() {
        return hallMapper.map(hallRepository.findAll());
    }

    @Transactional
    @Override
    public Hall save(HallParameters parameters) {
        var hall = hallRepository.save(hallMapper.map(parameters));
        return hallMapper.map(hall);
    }

    @Transactional
    @Override
    public void update(int id, HallParameters parameters) {
        var hall = hallRepository.findById(id).orElseThrow();
        hallMapper.fromDto(parameters, hall);
        hallRepository.save(hall);
    }

    @Transactional
    @Override
    public void delete(int id) {
        hallRepository.deleteById(id);
    }
}

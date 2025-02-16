package ru.gocinema.server.rest.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gocinema.restapi.model.Option;
import ru.gocinema.server.model.AppOption;
import ru.gocinema.server.repositories.AppOptionRepository;
import ru.gocinema.server.rest.mappers.AppOptionMapper;

@Service
@RequiredArgsConstructor
public class AppOptionServiceImpl implements AppOptionService {

    private final AppOptionMapper appOptionMapper;
    private final AppOptionRepository appOptionRepository;

    @Transactional
    @Override
    public void saveAppOption(Option option, String value) {
        AppOption appOption = appOptionRepository.findByOption(appOptionMapper.map(option));
        appOption.setValue(value);
        appOptionRepository.save(appOption);
    }

    @Override
    public AppOption getAppOption(Option option) {
        return appOptionRepository.findByOption(appOptionMapper.map(option));
    }
}

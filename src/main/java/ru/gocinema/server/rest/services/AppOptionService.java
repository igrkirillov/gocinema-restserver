package ru.gocinema.server.rest.services;


import ru.gocinema.restapi.model.Option;
import ru.gocinema.server.model.AppOption;

public interface AppOptionService {
    void saveAppOption(Option option, String value);
    AppOption getAppOption(Option option);
}

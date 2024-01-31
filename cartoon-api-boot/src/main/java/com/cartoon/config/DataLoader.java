package com.cartoon.config;

import com.cartoon.service.CharacterService;
import com.cartoon.service.impl.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CharacterServiceImpl characterServiceImpl;

    @Override
    public void run(String... args) throws Exception {
        characterServiceImpl.fetchAndSaveCharacters();
    }
}

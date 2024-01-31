package com.cartoon.config;

import com.cartoon.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CharacterService characterService;

    @Override
    public void run(String... args) throws Exception {
        characterService.fetchAndSaveCharacters();
    }
}

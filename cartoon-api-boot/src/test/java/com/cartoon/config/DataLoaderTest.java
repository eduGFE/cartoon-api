package com.cartoon.config;

import com.cartoon.controller.CartoonController;
import com.cartoon.service.CharacterService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.verify;



public class DataLoaderTest {

    @Mock
    private CharacterService characterService;

    @InjectMocks
    private DataLoader dataLoader;

    @Test
    public void testRun() throws Exception {
        MockitoAnnotations.openMocks(this);
        dataLoader.run();
        verify(characterService).fetchAndSaveCharacters();
    }
}
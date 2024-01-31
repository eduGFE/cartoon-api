package com.cartoon.service;

import com.cartoon.contract.vo.CartoonDTO;
import com.cartoon.dao.data.mapper.CharacterMapper;
import com.cartoon.service.impl.CharacterServiceImpl;
import com.cartoon.vo.response.character.CharacterResponse;
import com.cartoon.vo.response.episode.Episode;
import com.cartoon.vo.response.episode.EpisodeInfo;
import com.cartoon.vo.response.episode.EpisodeResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@Tag("characterServiceTest")
public class CharacterServiceTest {


    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);}

    @Mock
    private CharacterMapper characterMapper;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CharacterServiceImpl characterService;

    @Test
    public void testFindAllCartoons() {
        List<CartoonDTO> expectedCartoons = createCartoonsList();
        when(characterMapper.findAllCartoons()).thenReturn(expectedCartoons);
        List<CartoonDTO> actualCartoons = characterService.findAllCartoons();
        assertEquals(expectedCartoons, actualCartoons);
    }


    @Test
    public void fetchAndSaveCharactersTest() {
        EpisodeResponse episodeResponse = new EpisodeResponse();
        episodeResponse.setResults(Collections.singletonList(createTestEpisode()));
        when(restTemplate.getForObject(anyString(), eq(EpisodeResponse.class))).thenReturn(episodeResponse);
        CharacterResponse characterResponse1 = createTestCharacterResponse("Eduardo", "Activo");
        CharacterResponse characterResponse2 = createTestCharacterResponse("Javier", "Inactivo");
        when(restTemplate.getForObject(anyString(), eq(CharacterResponse.class)))
                .thenReturn(characterResponse1)
                .thenReturn(characterResponse2);
        characterService.fetchAndSaveCharacters();

        verify(characterMapper, times(1)).saveAll(anyList());
    }

    private Episode createTestEpisode() {
        Episode episode = new Episode();
        episode.setCharacters(Arrays.asList("url1", "url2"));
        return episode;
    }

    private CharacterResponse createTestCharacterResponse(String name, String status) {
        CharacterResponse characterResponse = new CharacterResponse();
        characterResponse.setName(name);
        characterResponse.setStatus(status);
        return characterResponse;
    }


    private List<CartoonDTO> createCartoonsList() {
        CartoonDTO cartoon1 = createCartoon("Eduardo", "Online");
        CartoonDTO cartoon2 = createCartoon("Javier", "Offline");
        return Arrays.asList(cartoon1, cartoon2);
    }

    private CartoonDTO createCartoon(String name, String status) {
        CartoonDTO cartoon = new CartoonDTO();
        cartoon.setName(name);
        cartoon.setStatus(status);
        return cartoon;
    }
}

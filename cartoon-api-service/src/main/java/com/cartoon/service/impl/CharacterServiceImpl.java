package com.cartoon.service.impl;

import com.cartoon.contract.vo.CartoonDTO;
import com.cartoon.dao.data.mapper.CharacterMapper;
import com.cartoon.service.CharacterService;
import com.cartoon.vo.response.character.CharacterResponse;
import com.cartoon.vo.response.episode.Episode;
import com.cartoon.vo.response.episode.EpisodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    public List<CartoonDTO> findAllCartoons() {
        return characterMapper.findAllCartoons();
    }


    public void fetchAndSaveCharacters() {
        String apiUrl = "https://rickandmortyapi.com/api/episode";
        EpisodeResponse episodeResponse = restTemplate.getForObject(apiUrl, EpisodeResponse.class);

        if (episodeResponse != null && episodeResponse.getResults() != null && !episodeResponse.getResults().isEmpty()) {
            Episode randomEpisode = getRandomEpisode(episodeResponse.getResults());

            List<CharacterResponse> charactersList = randomEpisode.getCharacters().stream()
                    .map(characterUrl -> restTemplate.getForObject(characterUrl, CharacterResponse.class))
                    .collect(Collectors.toList());
            characterMapper.saveAll(charactersList);
        }
    }

    private Episode getRandomEpisode(List<Episode> episodes) {
        Collections.shuffle(episodes);
        return episodes.get(0);
    }
}
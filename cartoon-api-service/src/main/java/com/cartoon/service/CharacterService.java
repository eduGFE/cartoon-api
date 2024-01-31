package com.cartoon.service;

import com.cartoon.dao.data.mapper.CharacterMapper;
import com.cartoon.vo.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CharacterService {

    @Autowired
    private CharacterMapper characterMapper;

    public void fetchAndSaveCharacters() {
        String apiUrl = "https://rickandmortyapi.com/api/character";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ApiResponse> response = restTemplate.exchange( apiUrl,HttpMethod.GET,null, new ParameterizedTypeReference<>() {});
        ApiResponse body = response.getBody();
        characterMapper.saveAll(body.getResults());
    }
}

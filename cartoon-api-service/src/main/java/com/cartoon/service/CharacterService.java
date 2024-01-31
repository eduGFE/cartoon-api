package com.cartoon.service;

import com.cartoon.contract.vo.CartoonDTO;


import java.util.List;


public interface CharacterService {

     void fetchAndSaveCharacters();

     List<CartoonDTO> findAllCartoons();

}

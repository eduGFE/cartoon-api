package com.cartoon.controller;


import com.cartoon.contract.api.CartoonsApi;
import com.cartoon.contract.vo.CartoonDTO;
import com.cartoon.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@AllArgsConstructor
public class CartoonController implements CartoonsApi {

    private final CharacterService characterService;

    @Override
    public ResponseEntity<List<CartoonDTO>> findAllCartoons() {
        List<CartoonDTO> allCartoons = characterService.findAllCartoons();
        return ResponseEntity.ok(allCartoons);
    }
}
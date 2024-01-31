package com.cartoon.dao.data.mapper;

import com.cartoon.contract.vo.CartoonDTO;
import com.cartoon.vo.response.character.CharacterResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CharacterMapper {

     void saveAll(List<CharacterResponse> results);

     List<CartoonDTO> findAllCartoons();

}

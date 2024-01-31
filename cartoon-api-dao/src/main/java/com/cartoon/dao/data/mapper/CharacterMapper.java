package com.cartoon.dao.data.mapper;

import com.cartoon.contract.vo.CartoonDTO;
import com.cartoon.vo.response.Character;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CharacterMapper {

     void saveAll(List<Character> results);

     List<CartoonDTO> findAllCartoons();

}

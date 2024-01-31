package com.cartoon.dao.data.mapper;

import com.cartoon.vo.response.ApiResponse;
import com.cartoon.vo.response.Character;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CharacterMapper {

     void saveAll(List<Character> results);

}

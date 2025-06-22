package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.CharacterResponse;
import com.sachinmukharjee.concepts.exception.APIException;
import com.sachinmukharjee.concepts.service.client.RickAndMortyApi;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RickAndMortyServiceImpl implements IRickAndMortyService {

  private RickAndMortyApi rickAndMortyApi;

  @Override
  public CharacterResponse getCharacter(Integer pageNo) {
    try {
      return rickAndMortyApi.getCharacter(pageNo);
    } catch (Exception e) {
      log.error("Exception occured while calling rick and morty api");
      throw new APIException("Error Occured while calling External APIS");
    }
  }
}

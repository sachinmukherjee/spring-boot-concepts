package com.sachinmukharjee.concepts.service;

import com.sachinmukharjee.concepts.dto.CharacterResponse;

public interface IRickAndMortyService {

    CharacterResponse getCharacter(Integer pageNo);
}

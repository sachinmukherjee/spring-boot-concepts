package com.sachinmukharjee.concepts.controller;

import com.sachinmukharjee.concepts.dto.CharacterResponse;
import com.sachinmukharjee.concepts.service.IRickAndMortyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/rickandmorty")
@AllArgsConstructor
@Slf4j
public class RickAndMortyController {

    private IRickAndMortyService rickAndMortyService;

    @GetMapping("/character")
    public CharacterResponse getCharacter(@RequestParam(name="pageNo",required = true,defaultValue = "1") Integer pageNo){
        CharacterResponse characterResponse = rickAndMortyService.getCharacter(pageNo);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Authentication {}",auth);
        return characterResponse;
    }
}

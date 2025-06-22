package com.sachinmukharjee.concepts.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponse {
  private Info info;
  private List<CharacterDto> results;
}

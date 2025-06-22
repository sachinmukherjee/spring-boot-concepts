package com.sachinmukharjee.concepts.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {
  private int count;
  private int pages;
  private String next;
  private String prev;
}

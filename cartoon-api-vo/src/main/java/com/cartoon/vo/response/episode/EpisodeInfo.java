package com.cartoon.vo.response.episode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EpisodeInfo {
    private int count;
    private int pages;
    private String next;
    private String prev;

}

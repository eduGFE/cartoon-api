package com.cartoon.vo.response.episode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EpisodeResponse {
    private EpisodeInfo info;
    private List<Episode> results;

}

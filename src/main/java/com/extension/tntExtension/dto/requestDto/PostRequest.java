package com.extension.tntExtension.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {

    @JsonProperty("post")
    private String post;
}

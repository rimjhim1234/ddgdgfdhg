package com.extension.tntExtension.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"username","password"})   //KI IS FORMAT ME HI LENA H  ya output aayega not sure yet
public class LoginRequest {

    @JsonProperty("username")   //iska matlab hnki yaha pr uch bhi likh aho postmane se username me hi aana chHIYE
    private String username;
    @JsonProperty("password")
    private String password;
}
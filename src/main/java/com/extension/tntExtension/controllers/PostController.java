package com.extension.tntExtension.controllers;

import com.extension.tntExtension.dto.requestDto.PostRequest;
import com.extension.tntExtension.dto.responseDto.WebResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/post")
public class PostController {

    @PostMapping("")
    @Operation(
            security = @SecurityRequirement(name = "token"),
            description = "Create Post service",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully created post!",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = "{\"code\" : 200, \"Status\" : \"Ok!\", \"Message\" :\"Successfully created post!\"}"
                                            ),
                                    }
                            )
                    )
            }
    )
    public ResponseEntity<?> createPost(@RequestBody PostRequest request) {
        return new ResponseEntity<>(new WebResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Successfully created post!"), HttpStatus.OK);
    }

}
package com.extension.tntExtension.controllers;

import com.commercetools.api.models.order.Order;
import com.extension.tntExtension.dto.RequestOrderDto;
import com.extension.tntExtension.dto.requestDto.LoginRequest;
import com.extension.tntExtension.dto.responseDto.WebResponse;
import com.extension.tntExtension.services.OrderService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    OrderService service;
    @PostMapping("/signIn")
    public ResponseEntity<?> signIn(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    value = "{\"username\" : \"admin test\", \"password\" : \"admin test\"}"
                            ),
                    }
            )) @RequestBody LoginRequest request) {
        return new ResponseEntity<>(new WebResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), "Successfully signed in!"), HttpStatus.OK);
    }

}
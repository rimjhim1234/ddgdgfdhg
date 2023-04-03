package com.extension.tntExtension.controllers;

import com.commercetools.api.models.error.ResourceNotFoundError;
import com.commercetools.api.models.order.Order;
import com.extension.tntExtension.dto.RequestOrderDto;
import com.extension.tntExtension.exceptionHandlers.ResourceNotFoundException;
import com.extension.tntExtension.services.OrderService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.vrap.rmf.base.client.error.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/responseOrder")
public class OrderController {
    @Autowired
    OrderService service;
    @PostMapping
    public ResponseEntity setOrderInLineItemCustomType(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    value = "{\n" +
                                            "    \"shipmentStatus\":\"pending\",\n" +
                                            "    \"expectedDeliveryTime\":\"2023-03-27T15:30:00\",\n" +
                                            "    \"latitude\":100.87,\n" +
                                            "    \"longitude\":100.09,\n" +
                                            "    \"reason\": {\n" +
                                            "        \"en\":\"At Home\"\n" +
                                            "    },\n" +
                                            "    \"deliveryImage\":\"image\",\n" +
                                            "    \"consingmentCode\":\"123151\",\n" +
                                            "    \"orderNumber\":\"4043\",\n" +
                                            "    \"version\":\"21\",\n" +
                                            "    \"lineItemId\":\"65dfb166-5190-4e8e-803c-30e413067177\"\n" +
                                            "}"
                            ),
                    }
            ))
            @RequestBody RequestOrderDto dto)
            throws Exception
    {
        Order order=null;
        try {
            order=service.setOrderInLineItemCustomType(dto);
        } catch (Exception e) {
            throw new ResourceNotFoundException("not found",HttpStatus.NOT_FOUND);
        }

        return    ResponseEntity.status(HttpStatus.OK).body(order);
    }


}

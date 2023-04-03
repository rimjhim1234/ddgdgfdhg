package com.extension.tntExtension.services;

import com.commercetools.api.models.order.*;

import com.extension.tntExtension.appConstants.Constants;
import com.extension.tntExtension.dao.OrderDao;
import com.extension.tntExtension.dto.RequestOrderDto;
import io.vrap.rmf.base.client.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    public Order setOrderInLineItemCustomType(RequestOrderDto dto) {
        String orderNumber = dto.getOrderNumber();

        OrderUpdate update = OrderUpdate.builder().version(dto.getVersion())
                .actions(OrderUpdateAction.setLineItemCustomTypeBuilder().lineItemId(dto.getLineItemId())
                        .type(typeBuilder -> typeBuilder.key(Constants.lineItemDeliveryTrackInfo))
                        .fields(fieldBuilder -> fieldBuilder.addValue(Constants.latitude, dto.getLatitude()).addValue(Constants.expectedDeliveryTime, dto.getFormattedExpectedDeliveryTime())
                                .addValue(Constants.longitude, dto.getLongitude()).addValue(Constants.reason, dto.getReason())
                                .addValue(Constants.deliveryImage, dto.getDeliveryImage()).addValue(Constants.consignmentCode, dto.getConsingmentCode())
                                .addValue(Constants.shipmentStatus, dto.getShipmentStatus())).build()).build();

        return orderDao.setOrderInLineItemCustomType(update, orderNumber);

    }

}

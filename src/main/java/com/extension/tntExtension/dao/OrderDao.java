package com.extension.tntExtension.dao;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.order.OrderUpdate;
import com.extension.tntExtension.config.ClientConfig;
import io.vrap.rmf.base.client.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public class OrderDao{
    @Autowired
    ProjectApiRoot apiRoot=new ClientConfig().createApiClient();

    public Order setOrderInLineItemCustomType(OrderUpdate update, String orderNumber)  {
          return  apiRoot.orders().withOrderNumber(orderNumber).post(update).executeBlocking().getBody();
    }


}

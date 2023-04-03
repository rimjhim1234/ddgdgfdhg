package com.extension.tntExtension.dto;

import com.commercetools.api.models.common.LocalizedString;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@JsonPropertyOrder({"username","password"})
public class RequestOrderDto {
    @JsonProperty("shipmentStatus")
    private String shipmentStatus;
    @JsonProperty("expectedDeliveryTime")
    private Date expectedDeliveryTime;
    @JsonProperty("latitude")
    private Number latitude;
    @JsonProperty("longitude")
    private Number longitude;
    @JsonProperty("reason")
    private LocalizedString reason;
    @JsonProperty("deliveryImage")
    private String deliveryImage;
    @JsonProperty("consingmentCode")
    private String consingmentCode;
    @JsonProperty("orderNumber")
    private String orderNumber;
    @JsonProperty("version")
    private Long version;
    @JsonProperty("lineItemId")
    private String lineItemId;

    public String getFormattedExpectedDeliveryTime() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return formatter.format(expectedDeliveryTime);
    }
}

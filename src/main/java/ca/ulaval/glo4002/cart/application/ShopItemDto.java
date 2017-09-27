package ca.ulaval.glo4002.cart.application;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShopItemDto {
    @JsonProperty
    public String name;

    @JsonProperty
    public String itemSku;
}

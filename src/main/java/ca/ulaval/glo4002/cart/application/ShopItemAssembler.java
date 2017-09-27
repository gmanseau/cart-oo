package ca.ulaval.glo4002.cart.application;

import java.util.List;

import ca.ulaval.glo4002.cart.domain.shop.ShopItem;

import static java.util.stream.Collectors.toList;

public class ShopItemAssembler {
    public List<ShopItemDto> toDto(List<ShopItem> cart) {
        return cart.stream().map(this::toDto).collect(toList());
    }

    private ShopItemDto toDto(ShopItem item) {
        ShopItemDto dto = new ShopItemDto();
        dto.name = item.getName();
        dto.itemSku = item.getSku();

        return dto;
    }
}

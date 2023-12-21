package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import br.com.cezarcruz.gymback.core.domain.Address;
import jakarta.validation.constraints.NotNull;

public record CreateAddressRequest (
    @NotNull
    String zipcode,

    @NotNull
    String street,

    @NotNull
    String neighborhood,

    @NotNull
    String num
) {

    public Address toAddress() {
        return new Address(null,
            zipcode(),
            street(),
            neighborhood(),
            num());
    }
}

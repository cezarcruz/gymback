package br.com.cezarcruz.gymback.gateway.in.rest.dto.request;

import br.com.cezarcruz.gymback.core.enums.ContactType;
import jakarta.validation.constraints.NotNull;

public record CreateContactRequest(

    @NotNull
    ContactType type,

    @NotNull
    String value
) {

}
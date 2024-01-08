package br.com.cezarcruz.gymback.application.rest.dto.response;

import br.com.gymback.core.enums.ContactType;

public record ContactResponse(
    ContactType type,
    String value
) {

}

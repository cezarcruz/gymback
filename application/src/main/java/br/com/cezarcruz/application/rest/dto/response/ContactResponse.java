package br.com.cezarcruz.application.rest.dto.response;

import br.com.cezarcruz.core.enums.ContactType;

public record ContactResponse(
    ContactType type,
    String value
) {

}

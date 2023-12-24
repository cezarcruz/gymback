package br.com.cezarcruz.gymback.core.domain;

import br.com.cezarcruz.gymback.core.enums.ContactType;

public record Contact(
    String id,
    ContactType type,
    String value
) {

}

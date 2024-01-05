package br.com.cezarcruz.core.domain;

import br.com.cezarcruz.core.enums.ContactType;

public record ContactDomain(
    String id,
    ContactType type,
    String value
) {

}

package br.com.gymback.core.domain;

import br.com.gymback.core.enums.ContactType;

public record ContactDomain(
    String id,
    ContactType type,
    String value
) {

}

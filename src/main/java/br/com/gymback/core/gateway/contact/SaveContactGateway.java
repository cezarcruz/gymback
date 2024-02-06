package br.com.gymback.core.gateway.contact;

import br.com.gymback.core.domain.ContactDomain;

public interface SaveContactGateway {
  ContactDomain save(final ContactDomain contact);
}

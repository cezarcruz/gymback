package br.com.cezarcruz.gymback.core.gateway.contact;

import br.com.cezarcruz.gymback.core.domain.ContactDomain;
import java.util.List;

public interface SaveContactGateway {
  List<ContactDomain> save(final List<ContactDomain> contacts);
}

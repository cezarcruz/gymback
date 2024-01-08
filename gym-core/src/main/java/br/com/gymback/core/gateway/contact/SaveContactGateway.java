package br.com.gymback.core.gateway.contact;

import br.com.gymback.core.domain.ContactDomain;
import java.util.List;

public interface SaveContactGateway {
  List<ContactDomain> save(final List<ContactDomain> contacts);
}

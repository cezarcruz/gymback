package br.com.cezarcruz.core.gateway.contact;

import br.com.cezarcruz.core.domain.ContactDomain;
import java.util.List;

public interface SaveContactGateway {
  List<ContactDomain> save(final List<ContactDomain> contacts);
}

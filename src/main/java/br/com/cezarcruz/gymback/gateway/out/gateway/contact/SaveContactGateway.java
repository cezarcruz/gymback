package br.com.cezarcruz.gymback.gateway.out.gateway.contact;

import br.com.cezarcruz.gymback.core.domain.Contact;
import java.util.List;

public interface SaveContactGateway {
  List<Contact> save(final List<Contact> contacts);
}

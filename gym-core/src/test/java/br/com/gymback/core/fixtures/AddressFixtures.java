package br.com.gymback.core.fixtures;

import br.com.gymback.core.domain.AddressDomain;
import org.instancio.Instancio;

public class AddressFixtures {

  public static AddressDomain getAddress() {
    return Instancio.create(AddressDomain.class);
  }
}

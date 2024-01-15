package br.com.gymback.persistence.fixture;

import static org.instancio.Select.field;

import br.com.gymback.core.domain.AddressDomain;
import org.instancio.Instancio;

//todo how to share test code?
public class AddressFixtures {

  public static AddressDomain getAddress() {
    return Instancio
        .of(AddressDomain.class)
        .generate(field("street"), gen -> gen.string().length(30))
        .generate(field("zipcode"), gen -> gen.string().length(8))
        .generate(field("state"), gen -> gen.string().length(2))
        .generate(field("city"), gen -> gen.string().length(15))
        .generate(field("neighborhood"), gen -> gen.string().length(10))
        .generate(field("addressNumber"), gen -> gen.string().length(4))
        .create();

  }
}

/* Under MIT License (C)2024 */
package br.com.gymback.core.fixtures;

import br.com.gymback.core.domain.PaymentDomain;
import org.instancio.Instancio;

public class PaymentFixture {

  public static PaymentDomain getPayment() {
    return Instancio.create(PaymentDomain.class);
  }
}

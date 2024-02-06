/* Under MIT License (C)2024 */
package br.com.gymback.application.fixtures;

import br.com.gymback.core.domain.ModalityDomain;
import org.instancio.Instancio;

public class ModalityFixtures {

  public static ModalityDomain getModalityDomain() {
    return Instancio.create(ModalityDomain.class);
  }
}

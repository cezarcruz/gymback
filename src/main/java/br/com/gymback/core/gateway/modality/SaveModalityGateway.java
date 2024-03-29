/* Under MIT License (C)2024 */
package br.com.gymback.core.gateway.modality;

import br.com.gymback.core.domain.ModalityDomain;

public interface SaveModalityGateway {

  ModalityDomain save(final ModalityDomain modality);
}

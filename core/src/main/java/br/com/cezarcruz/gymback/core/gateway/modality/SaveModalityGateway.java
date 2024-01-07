package br.com.cezarcruz.gymback.core.gateway.modality;

import br.com.cezarcruz.gymback.core.domain.ModalityDomain;

public interface SaveModalityGateway {

  ModalityDomain save(final ModalityDomain modality);

}

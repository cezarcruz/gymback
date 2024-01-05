package br.com.cezarcruz.gymback.gateway.out.gateway.modality;

import br.com.cezarcruz.gymback.core.domain.ModalityDomain;

public interface SaveModalityGateway {

  ModalityDomain save(final ModalityDomain modality);

}

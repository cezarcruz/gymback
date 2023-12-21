package br.com.cezarcruz.gymback.gateway.out.persistence;

import br.com.cezarcruz.gymback.core.domain.Modality;

public interface SaveModalityGateway {

  Modality save(final Modality modality);

}

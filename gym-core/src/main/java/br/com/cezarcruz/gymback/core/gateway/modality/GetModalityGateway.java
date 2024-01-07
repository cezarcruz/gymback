package br.com.cezarcruz.gymback.core.gateway.modality;

import br.com.cezarcruz.gymback.core.domain.ModalityDomain;
import java.util.Optional;
import java.util.stream.Stream;

public interface GetModalityGateway {
  Stream<ModalityDomain> getAll();

  Optional<ModalityDomain> findById(String id);
}

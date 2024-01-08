package br.com.gymback.core.gateway.modality;

import br.com.gymback.core.domain.ModalityDomain;
import java.util.Optional;
import java.util.stream.Stream;

public interface GetModalityGateway {
  Stream<ModalityDomain> getAll();

  Optional<ModalityDomain> findById(String id);
}

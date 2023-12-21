package br.com.cezarcruz.gymback.gateway.out.gateway.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import java.util.stream.Stream;

public interface GetModalityGateway {
  Stream<Modality> getAll();
}

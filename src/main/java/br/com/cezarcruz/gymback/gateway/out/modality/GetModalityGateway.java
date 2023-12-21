package br.com.cezarcruz.gymback.gateway.out.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import java.util.stream.Stream;

public interface GetModalityGateway {
  Stream<Modality> getAll();
}

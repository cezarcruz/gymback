package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.GetModalityGateway;
import jakarta.inject.Named;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetModalityUseCase {

    private final GetModalityGateway getModalityGateway;

    public Stream<Modality> getAll() {
        return getModalityGateway.getAll();
    }

}

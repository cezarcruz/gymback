package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.ModalityDomain;
import br.com.cezarcruz.gymback.core.gateway.modality.GetModalityGateway;
import jakarta.inject.Named;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetModalityUseCase {

    private final GetModalityGateway getModalityGateway;

    public Stream<ModalityDomain> getAll() {
        return getModalityGateway.getAll();
    }

}

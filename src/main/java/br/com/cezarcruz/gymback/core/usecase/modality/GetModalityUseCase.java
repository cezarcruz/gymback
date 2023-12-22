package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.GetModalityGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class GetModalityUseCase {

    private final GetModalityGateway getModalityGateway;

    public Stream<Modality> getAll() {
        return getModalityGateway.getAll();
    }

}

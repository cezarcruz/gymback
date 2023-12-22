package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.gateway.out.gateway.modality.DeleteModalityGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteModalityUseCase {

    private final DeleteModalityGateway deleteModalityGateway;

    public void deleteBy(final Long id) {
        deleteModalityGateway.deleteById(id);
    }

}

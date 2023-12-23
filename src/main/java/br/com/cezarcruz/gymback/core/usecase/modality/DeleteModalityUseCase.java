package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.gateway.out.gateway.modality.DeleteModalityGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class DeleteModalityUseCase {

    private final DeleteModalityGateway deleteModalityGateway;

    public void deleteBy(final String id) {
        deleteModalityGateway.deleteById(id);
    }

}

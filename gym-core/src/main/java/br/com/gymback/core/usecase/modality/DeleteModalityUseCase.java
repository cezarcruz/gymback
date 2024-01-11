package br.com.gymback.core.usecase.modality;

import br.com.gymback.core.gateway.modality.DeleteModalityGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class DeleteModalityUseCase {

    private final DeleteModalityGateway deleteModalityGateway;

    public void deleteBy(final Long id) {
        deleteModalityGateway.deleteById(id);
    }

}

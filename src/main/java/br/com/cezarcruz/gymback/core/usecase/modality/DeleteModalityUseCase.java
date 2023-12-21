package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.gateway.out.modality.DeleteModalityGateway;
import org.springframework.stereotype.Component;

@Component
public class DeleteModalityUseCase {

    private final DeleteModalityGateway deleteModalityGateway;

    public DeleteModalityUseCase(final DeleteModalityGateway deleteModalityGateway) {
        this.deleteModalityGateway = deleteModalityGateway;
    }

    public void deleteBy(final Long id) {
        deleteModalityGateway.deleteById(id);
    }

}

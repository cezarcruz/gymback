package br.com.gymback.core.usecase.modality;

import br.com.gymback.core.domain.ModalityDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.modality.GetModalityGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetModalityUseCase {

    private final GetModalityGateway getModalityGateway;

    public PageDomain<ModalityDomain> findAll(final PageDomain<ModalityDomain> page) {
        return getModalityGateway.findAll(page);
    }

}

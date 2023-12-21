package br.com.cezarcruz.gymback.modality.application.usecase;

import br.com.cezarcruz.gymback.modality.domain.model.Modality;
import br.com.cezarcruz.gymback.modality.domain.usecase.CreateModalityUseCase;
import br.com.cezarcruz.gymback.modality.infra.repository.ModalityRepository;
import org.springframework.stereotype.Component;

@Component
class CreateModalityUseCaseImpl implements CreateModalityUseCase {

    private final ModalityRepository createModalityRepository;

    public CreateModalityUseCaseImpl(ModalityRepository createModalityRepository) {
        this.createModalityRepository = createModalityRepository;
    }

    @Override
    public Modality create(final Modality modality) {

        final var entity = modality.toEntity();
        final var saved = createModalityRepository.save(entity);
        return Modality.fromEntity(saved);
    }

}

package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.mysql.ModalityRepository;
import org.springframework.stereotype.Component;

@Component
public class CreateModalityUseCase {

    private final ModalityRepository createModalityRepository;

    public CreateModalityUseCase(ModalityRepository createModalityRepository) {
        this.createModalityRepository = createModalityRepository;
    }

    public Modality create(final Modality modality) {

        final var entity = modality.toEntity();
        final var saved = createModalityRepository.save(entity);
        return Modality.fromEntity(saved);
    }

}

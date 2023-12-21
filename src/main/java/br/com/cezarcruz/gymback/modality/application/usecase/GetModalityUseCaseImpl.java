package br.com.cezarcruz.gymback.modality.application.usecase;

import br.com.cezarcruz.gymback.modality.domain.model.Modality;
import br.com.cezarcruz.gymback.modality.domain.usecase.GetModalityUseCase;
import br.com.cezarcruz.gymback.modality.infra.repository.ModalityRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
class GetModalityUseCaseImpl implements GetModalityUseCase {

    private final ModalityRepository modalityRepository;

    public GetModalityUseCaseImpl(final ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }

    @Override
    public Stream<Modality> getAll() {
        return modalityRepository.findAll()
                .stream()
                .map(Modality::fromEntity);
    }

}

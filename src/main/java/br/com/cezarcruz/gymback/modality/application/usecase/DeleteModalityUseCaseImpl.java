package br.com.cezarcruz.gymback.modality.application.usecase;

import br.com.cezarcruz.gymback.modality.domain.usecase.DeleteModalityUseCase;
import br.com.cezarcruz.gymback.modality.infra.repository.ModalityRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteModalityUseCaseImpl implements DeleteModalityUseCase {

    private final ModalityRepository modalityRepository;

    public DeleteModalityUseCaseImpl(final ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }

    @Override
    public void deleteBy(final Long id) {
        modalityRepository.deleteById(id);
    }

}

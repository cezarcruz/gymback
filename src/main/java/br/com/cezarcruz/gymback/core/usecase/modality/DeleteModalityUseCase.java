package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.gateway.out.mysql.ModalityRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteModalityUseCase {

    private final ModalityRepository modalityRepository;

    public DeleteModalityUseCase(final ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }

    public void deleteBy(final Long id) {
        modalityRepository.deleteById(id);
    }

}

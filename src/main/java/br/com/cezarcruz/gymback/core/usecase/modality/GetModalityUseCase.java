package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.mysql.ModalityRepository;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class GetModalityUseCase {

    private final ModalityRepository modalityRepository;

    public GetModalityUseCase(final ModalityRepository modalityRepository) {
        this.modalityRepository = modalityRepository;
    }

    public Stream<Modality> getAll() {
        return modalityRepository.findAll()
                .stream()
                .map(Modality::fromEntity);
    }

}

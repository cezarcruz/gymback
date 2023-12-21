package br.com.cezarcruz.gymback.core.usecase.modality;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.mysql.ModalityRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateModalityUseCase {

  private final ModalityRepository modalityRepository;

  public UpdateModalityUseCase(final ModalityRepository modalityRepository) {
    this.modalityRepository = modalityRepository;
  }

  public Modality update(final Modality modality) {
    final var entity = modality.toEntity();
    final var saved = modalityRepository.save(entity);
    return Modality.fromEntity(saved);
  }

}

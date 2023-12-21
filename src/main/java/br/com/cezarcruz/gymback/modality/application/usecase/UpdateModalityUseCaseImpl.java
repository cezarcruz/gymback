package br.com.cezarcruz.gymback.modality.application.usecase;

import br.com.cezarcruz.gymback.modality.domain.model.Modality;
import br.com.cezarcruz.gymback.modality.domain.usecase.UpdateModalityUseCase;
import br.com.cezarcruz.gymback.modality.infra.repository.ModalityRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateModalityUseCaseImpl implements UpdateModalityUseCase {

  private final ModalityRepository modalityRepository;

  public UpdateModalityUseCaseImpl(final ModalityRepository modalityRepository) {
    this.modalityRepository = modalityRepository;
  }

  @Override
  public Modality update(final Modality modality) {
    final var entity = modality.toEntity();
    final var saved = modalityRepository.save(entity);
    return Modality.fromEntity(saved);
  }

}

package br.com.cezarcruz.gymback.modality.domain.usecase;

import br.com.cezarcruz.gymback.modality.domain.model.Modality;

public interface CreateModalityUseCase {
    Modality create(final Modality modality);
}

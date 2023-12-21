package br.com.cezarcruz.gymback.modality.domain.usecase;

import br.com.cezarcruz.gymback.modality.domain.model.Modality;

import java.util.stream.Stream;

public interface GetModalityUseCase {

    Stream<Modality> getAll();

}

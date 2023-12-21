package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.persistence.GetModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.SaveModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.UpdateModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.ModalityRepository;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class ModalityMysqlGateway implements SaveModalityGateway, GetModalityGateway,
    UpdateModalityGateway {

  private final ModalityRepository modalityRepository;

  public ModalityMysqlGateway(final ModalityRepository modalityRepository) {
    this.modalityRepository = modalityRepository;
  }

  @Override
  public Modality save(Modality modality) {
    final var entity = modality.toEntity();
    final var saved = modalityRepository.save(entity);
    return Modality.fromEntity(saved);
  }

  @Override
  public Stream<Modality> getAll() {
    return modalityRepository.findAll()
        .stream()
        .map(Modality::fromEntity);
  }

  @Override
  public Modality update(Modality modality) {
    final var entity = modality.toEntity();
    final var saved = modalityRepository.save(entity);
    return Modality.fromEntity(saved);
  }
}

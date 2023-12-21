package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Modality;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.DeleteModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.GetModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.SaveModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.ModalityRepository;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class ModalityMysqlGateway implements SaveModalityGateway, GetModalityGateway,
    DeleteModalityGateway {

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
  public void deleteById(Long id) {
    modalityRepository.deleteById(id);
  }
}

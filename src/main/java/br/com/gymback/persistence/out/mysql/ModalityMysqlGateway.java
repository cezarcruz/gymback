/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.ModalityDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.modality.DeleteModalityGateway;
import br.com.gymback.core.gateway.modality.GetModalityGateway;
import br.com.gymback.core.gateway.modality.SaveModalityGateway;
import br.com.gymback.persistence.out.mysql.mapper.ModalityPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ModalityRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class ModalityMysqlGateway
    implements SaveModalityGateway, GetModalityGateway, DeleteModalityGateway {

  private final ModalityRepository modalityRepository;
  private final ModalityPersistenceMapper modalityPersistenceMapper;

  @Override
  public ModalityDomain save(ModalityDomain modality) {
    final var entity = modalityPersistenceMapper.from(modality);
    final var saved = modalityRepository.save(entity);
    return modalityPersistenceMapper.from(saved);
  }

  @Override
  public PageDomain<ModalityDomain> findAll(final PageDomain<ModalityDomain> page) {
    var pageRequest = PageRequest.of(page.getPage(), page.getSize());

    var modalities = modalityRepository.findAll(pageRequest);
    return modalityPersistenceMapper.toPageDomain(page, modalities);
  }

  @Override
  public void deleteById(final Long id) {
    modalityRepository.deleteById(id);
  }

  @Override
  public Optional<ModalityDomain> findById(Long id) {
    return modalityRepository.findById(id).map(modalityPersistenceMapper::from);
  }
}

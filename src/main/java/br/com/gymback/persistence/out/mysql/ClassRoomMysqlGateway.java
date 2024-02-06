/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.classroom.GetClassRoomGateway;
import br.com.gymback.core.gateway.classroom.SaveClassRoomGateway;
import br.com.gymback.persistence.out.mysql.mapper.ClassRoomPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ClassRoomRepository;
import jakarta.inject.Named;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Named
@RequiredArgsConstructor
public class ClassRoomMysqlGateway implements SaveClassRoomGateway, GetClassRoomGateway {

  private final ClassRoomRepository classRoomRepository;
  private final ClassRoomPersistenceMapper classRoomPersistenceMapper;

  @Override
  public ClassRoomDomain save(ClassRoomDomain classRoom) {
    final var classRoomEntity = classRoomPersistenceMapper.fromDomain(classRoom);
    var saved = classRoomRepository.save(classRoomEntity);
    return classRoomPersistenceMapper.fromEntity(saved);
  }

  @Override
  public PageDomain<ClassRoomDomain> findAll(final PageDomain<ClassRoomDomain> page) {
    var pageRequest = PageRequest.of(page.getPage(), page.getSize());
    final var pagedValues = classRoomRepository.findAllWithJoin(pageRequest);
    return classRoomPersistenceMapper.toPageDomain(page, pagedValues);
  }

  @Override
  public Optional<ClassRoomDomain> findById(final Long id) {
    return classRoomRepository.findById(id).map(classRoomPersistenceMapper::fromEntity);
  }
}

package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.classroom.GetClassRoomGateway;
import br.com.gymback.core.gateway.classroom.SaveClassRoomGateway;
import br.com.gymback.persistence.out.mysql.mapper.ClassRoomPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ClassRoomRepository;
import jakarta.inject.Named;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

@Named
@RequiredArgsConstructor
public class ClassRoomMysqlGateway implements SaveClassRoomGateway, GetClassRoomGateway {

  private final ClassRoomRepository classRoomRepository;
  private final ClassRoomPersistenceMapper classRoomPersistenceMapper;

  @Override
  public ClassRoomDomain save(ClassRoomDomain classRoom) {
    final var classRoomEntity = classRoomPersistenceMapper.from(classRoom);
    var saved = classRoomRepository.save(classRoomEntity);
    return classRoomPersistenceMapper.from(saved);
  }

  @Override
  public PageDomain<ClassRoomDomain> getAll(final PageDomain<ClassRoomDomain> page) {
    var pageRequest = PageRequest.of(page.getPage(), page.getSize());;
    final var pagedValues = classRoomRepository.findAllWithJoin(pageRequest);

     var values = pagedValues
        .stream()
        .map(classRoomPersistenceMapper::from)
         .collect(Collectors.toList());

    return page.toBuilder()
        .elements(values)
        .totalElements(pagedValues.getTotalElements())
        .totalPages(pagedValues.getTotalPages())
        .build();
  }

  @Override
  public Stream<ClassRoomDomain> findAll() {
    return null;
  }

  @Override
  public Optional<ClassRoomDomain> findById(String id) {
    return classRoomRepository.findById(id)
        .map(classRoomPersistenceMapper::from);
  }

}

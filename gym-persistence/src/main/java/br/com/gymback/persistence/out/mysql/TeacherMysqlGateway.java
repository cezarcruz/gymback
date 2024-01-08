package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.TeacherDomain;
import br.com.gymback.persistence.out.mysql.mapper.TeacherPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.TeacherRepository;
import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.gateway.teacher.DeleteTeacherGateway;
import br.com.gymback.core.gateway.teacher.GetTeacherGateway;
import br.com.gymback.core.gateway.teacher.SaveTeacherGateway;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class TeacherMysqlGateway implements SaveTeacherGateway, DeleteTeacherGateway,
    GetTeacherGateway {

  private final TeacherRepository teacherRepository;
  private final TeacherPersistenceMapper teacherPersistenceMapper;

  @Override
  public TeacherDomain save(final TeacherDomain teacher) {
    final var entity = teacherPersistenceMapper.from(teacher);
    final var saved = teacherRepository.save(entity);
    return teacherPersistenceMapper.from(saved);
  }

  @Override
  public void deleteTeacher(final String id) {
    teacherRepository.deleteById(id);
  }

  @Override
  public PageDomain<TeacherDomain> getAll(final PageDomain<TeacherDomain> page) {

    var pageRequest = PageRequest.of(page.getPage(), page.getSize());

    final var pagedTeachers = teacherRepository.findAllWithPerformance(pageRequest);

    var values = pagedTeachers
        .stream()
        .map(teacherPersistenceMapper::from)
        .toList();

    return page.toBuilder()
        .elements(values)
        .totalElements(pagedTeachers.getTotalElements())
        .totalPages(pagedTeachers.getTotalPages())
        .build();
  }

  @Override
  public Optional<TeacherDomain> findById(final String id) {
    return teacherRepository.findById(id)
        .map(teacherPersistenceMapper::from);
  }
}

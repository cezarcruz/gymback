package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.DeleteTeacherGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.GetTeacherGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.SaveTeacherGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper.TeacherPersistenceMapper;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.TeacherRepository;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class TeacherMysqlGateway implements SaveTeacherGateway, DeleteTeacherGateway,
    GetTeacherGateway {

  private final TeacherRepository teacherRepository;
  private final TeacherPersistenceMapper teacherPersistenceMapper;

  @Override
  public Teacher save(final Teacher teacher) {
    final var entity = teacherPersistenceMapper.from(teacher);
    final var saved = teacherRepository.save(entity);
    return teacherPersistenceMapper.from(saved);
  }

  @Override
  public void deleteTeacher(final String id) {
    teacherRepository.deleteById(id);
  }

  @Override
  public Stream<Teacher> getAll() {
    return teacherRepository.findAll()
        .stream()
        .map(teacherPersistenceMapper::from);
  }

  @Override
  public Optional<Teacher> findById(final String id) {
    return teacherRepository.findById(id)
        .map(teacherPersistenceMapper::from);
  }
}

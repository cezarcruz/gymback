package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.DeleteTeacherGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.GetTeacherGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.SaveTeacherGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.TeacherRepository;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
class TeacherMysqlGateway implements SaveTeacherGateway, DeleteTeacherGateway,
    GetTeacherGateway {

  private final TeacherRepository teacherRepository;

  public TeacherMysqlGateway(final TeacherRepository teacherRepository) {
    this.teacherRepository = teacherRepository;
  }

  @Override
  public Teacher save(Teacher teacher) {
    final var entity = teacher.toEntity();
    final var saved = teacherRepository.save(entity);
    return Teacher.fromEntity(saved);
  }

  @Override
  public void deleteTeacher(Long id) {
    teacherRepository.deleteById(id);
  }

  @Override
  public Stream<Teacher> getAll() {
    return teacherRepository.findAll()
        .stream()
        .map(Teacher::fromEntity);
  }
}

package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.teacher.DeleteTeacherGateway;
import br.com.cezarcruz.gymback.gateway.out.teacher.SaveTeacherGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.TeacherRepository;
import org.springframework.stereotype.Component;

@Component
public class TeacherMysqlGateway implements SaveTeacherGateway, DeleteTeacherGateway {

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
}

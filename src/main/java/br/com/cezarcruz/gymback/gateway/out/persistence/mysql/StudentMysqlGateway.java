package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.GetStudentGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveStudentGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.StudentRepository;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class StudentMysqlGateway implements SaveStudentGateway, GetStudentGateway {

  private final StudentRepository studentRepository;

  @Override
  public Student save(final Student student) {

    final var entity = student.toEntity();
    final var saved = studentRepository.save(entity);
    return Student.fromEntity(saved);

  }

  @Override
  public Stream<Student> findAll() {
    return studentRepository.findAll()
        .stream()
        .map(Student::fromEntity);
  }
}

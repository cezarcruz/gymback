package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Student;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.GetStudentGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.student.SaveStudentGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper.StudentPersistenceMapper;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.StudentRepository;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class StudentMysqlGateway implements SaveStudentGateway, GetStudentGateway {

  private final StudentRepository studentRepository;
  private final StudentPersistenceMapper studentPersistenceMapper;

  @Override
  public Student save(final Student student) {

    final var entity = studentPersistenceMapper.from(student);
    final var saved = studentRepository.save(entity);
    return studentPersistenceMapper.from(saved);

  }

  @Override
  public Stream<Student> findAll() {
    return studentRepository.findAll()
        .stream()
        .map(studentPersistenceMapper::from);
  }

  @Override
  public Optional<Student> findById(final String id) {
    return studentRepository
        .findById(id)
        .map(studentPersistenceMapper::from);
  }
}

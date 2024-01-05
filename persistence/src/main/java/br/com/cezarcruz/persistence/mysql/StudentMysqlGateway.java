package br.com.cezarcruz.persistence.mysql;

import br.com.cezarcruz.core.domain.StudentDomain;
import br.com.cezarcruz.core.gateway.student.GetStudentGateway;
import br.com.cezarcruz.core.gateway.student.SaveStudentGateway;
import br.com.cezarcruz.persistence.mysql.mapper.StudentPersistenceMapper;
import br.com.cezarcruz.persistence.mysql.repository.StudentRepository;
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
  public StudentDomain save(final StudentDomain student) {

    final var entity = studentPersistenceMapper.from(student);
    final var saved = studentRepository.save(entity);
    return studentPersistenceMapper.from(saved);

  }

  @Override
  public Stream<StudentDomain> findAll() {
    return studentRepository.findAll()
        .stream()
        .map(studentPersistenceMapper::from);
  }

  @Override
  public Optional<StudentDomain> findById(final String id) {
    return studentRepository
        .findById(id)
        .map(studentPersistenceMapper::from);
  }
}

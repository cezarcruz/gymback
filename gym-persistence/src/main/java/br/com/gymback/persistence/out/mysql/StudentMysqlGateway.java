package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.gateway.student.GetStudentGateway;
import br.com.gymback.core.gateway.student.SaveStudentGateway;
import br.com.gymback.persistence.out.mysql.mapper.StudentPersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.StudentRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class StudentMysqlGateway implements SaveStudentGateway, GetStudentGateway {

  private final StudentRepository studentRepository;
  private final StudentPersistenceMapper studentPersistenceMapper;

  @Override
  public StudentDomain save(final StudentDomain student) {

    final var entity = studentPersistenceMapper.toEntity(student);
    final var saved = studentRepository.save(entity);
    return studentPersistenceMapper.toDomain(saved);

  }

  @Override
  public PageDomain<StudentDomain> findAll(final PageDomain<StudentDomain> page) {
    var pageRequest = PageRequest.of(page.getPage(), page.getSize());
    var students =  studentRepository.findAll(pageRequest);
    return studentPersistenceMapper.toPageDomain(page, students);
  }

  @Override
  public Optional<StudentDomain> findById(final String id) {
    return studentRepository
        .findById(id)
        .map(studentPersistenceMapper::toDomain);
  }
}

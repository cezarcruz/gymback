/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.student;

import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.gateway.student.GetStudentGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class GetStudentUseCase {

  private final GetStudentGateway getStudentGateway;

  public PageDomain<StudentDomain> findAll(final PageDomain<StudentDomain> page) {
    return getStudentGateway.findAll(page);
  }
}

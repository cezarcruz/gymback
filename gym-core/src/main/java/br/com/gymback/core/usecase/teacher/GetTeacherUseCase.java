package br.com.gymback.core.usecase.teacher;

import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.TeacherDomain;
import br.com.gymback.core.gateway.teacher.GetTeacherGateway;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class GetTeacherUseCase {

    private final GetTeacherGateway getTeacherGateway;

  public GetTeacherUseCase(GetTeacherGateway getTeacherGateway) {
    this.getTeacherGateway = getTeacherGateway;
  }

  public PageDomain<TeacherDomain> findAll(final PageDomain<TeacherDomain> page) {
        log.info("listing all teachers");
        return getTeacherGateway.findAll(page);
    }

}

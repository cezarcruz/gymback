package br.com.gymback.core.usecase.teacher;

import br.com.gymback.core.domain.PageDomain;
import br.com.gymback.core.domain.Teacher;
import br.com.gymback.core.gateway.teacher.GetTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
@RequiredArgsConstructor
public class GetTeacherUseCase {

    private final GetTeacherGateway getTeacherGateway;

    public PageDomain<Teacher> getAll(final PageDomain<Teacher> page) {
        log.info("listing all teachers");
        return getTeacherGateway.getAll(page);
    }

}

package br.com.cezarcruz.gymback.core.usecase.teacher;

import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.GetTeacherGateway;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetTeacherUseCase {

    private final GetTeacherGateway getTeacherGateway;

    public Stream<Teacher> getAll() {
        log.info("listing all teachers");
        return getTeacherGateway.getAll();
    }

}

package br.com.cezarcruz.gymback.gateway.in.rest;

import br.com.cezarcruz.gymback.core.usecase.teacher.CreateTeacherUseCase;
import br.com.cezarcruz.gymback.core.usecase.teacher.DeleteTeacherUseCase;
import br.com.cezarcruz.gymback.core.usecase.teacher.GetTeacherUseCase;
import br.com.cezarcruz.gymback.core.usecase.teacher.UpdateTeacherUseCase;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.TeacherResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;
    private final GetTeacherUseCase getTeacherUseCase;
    private final UpdateTeacherUseCase updateTeacherUseCase;
    private final DeleteTeacherUseCase deleteTeacherUseCase;

    public TeacherController(final CreateTeacherUseCase createTeacherUseCase,
                             final GetTeacherUseCase getTeacherUseCase,
                             final UpdateTeacherUseCase updateTeacherUseCase,
                             final DeleteTeacherUseCase deleteTeacherUseCase) {
        this.createTeacherUseCase = createTeacherUseCase;
        this.getTeacherUseCase = getTeacherUseCase;
        this.updateTeacherUseCase = updateTeacherUseCase;
        this.deleteTeacherUseCase = deleteTeacherUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse create(@Valid @RequestBody final CreateTeacherRequest createTeacherRequest) {

        final var teacher = createTeacherRequest.toTeacher();
        final var createdTeacher = createTeacherUseCase.create(teacher);
        return TeacherResponse.from(createdTeacher);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherResponse> getAll() {
        return getTeacherUseCase.getAll()
                .map(TeacherResponse::from)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse update(@Valid @RequestBody final UpdateTeacherRequest updateTeacherRequest,
                                  @PathVariable("id") final Long id) {
        final var teacher = updateTeacherRequest.toTeacher(id);
        final var updatedTeacher = updateTeacherUseCase.update(teacher);
        return TeacherResponse.from(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
        deleteTeacherUseCase.deleteBy(id);
    }

}

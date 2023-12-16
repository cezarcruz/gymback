package br.com.cezarcruz.gymback.teacher.application.controller;

import br.com.cezarcruz.gymback.teacher.domain.dto.request.CreateTeacherRequest;
import br.com.cezarcruz.gymback.teacher.domain.dto.response.TeacherResponse;
import br.com.cezarcruz.gymback.teacher.domain.usecase.CreateTeacherUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;

    public TeacherController(final CreateTeacherUseCase createTeacherUseCase) {
        this.createTeacherUseCase = createTeacherUseCase;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse create(@Valid final CreateTeacherRequest createTeacherRequest) {

        final var teacher = createTeacherRequest.toTeacher();
        final var createdTeacher = createTeacherUseCase.create(teacher);
        return TeacherResponse.from(createdTeacher);

    }

}

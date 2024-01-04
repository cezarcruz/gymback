package br.com.cezarcruz.gymback.gateway.in.rest;

import br.com.cezarcruz.gymback.core.domain.PageDomain;
import br.com.cezarcruz.gymback.core.domain.Teacher;
import br.com.cezarcruz.gymback.core.usecase.teacher.CreateTeacherUseCase;
import br.com.cezarcruz.gymback.core.usecase.teacher.DeleteTeacherUseCase;
import br.com.cezarcruz.gymback.core.usecase.teacher.GetTeacherUseCase;
import br.com.cezarcruz.gymback.core.usecase.teacher.UpdateTeacherUseCase;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.GetPagingRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.UpdateTeacherRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.PageResponse;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.TeacherResponse;
import br.com.cezarcruz.gymback.gateway.in.rest.mapper.TeacherMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
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
@RequiredArgsConstructor
@RequestMapping(value = "/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
public class TeacherController {

    private final CreateTeacherUseCase createTeacherUseCase;
    private final GetTeacherUseCase getTeacherUseCase;
    private final UpdateTeacherUseCase updateTeacherUseCase;
    private final DeleteTeacherUseCase deleteTeacherUseCase;
    private final TeacherMapper teacherMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherResponse create(@Valid @RequestBody final CreateTeacherRequest createTeacherRequest) {

        final var teacher = teacherMapper.fromRequest(createTeacherRequest);
        final var createdTeacher = createTeacherUseCase.create(teacher);
        return teacherMapper.fromDomain(createdTeacher);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageResponse<TeacherResponse> getAll(@ParameterObject final GetPagingRequest paging) {
        var page = new PageDomain<Teacher>(paging.page(), paging.size());

        final var pagedTeachers = getTeacherUseCase.getAll(page);
        return teacherMapper.fromPageDomain(pagedTeachers);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse update(@Valid @RequestBody final UpdateTeacherRequest updateTeacherRequest,
                                  @PathVariable("id") final String id) {
        final var teacher = teacherMapper.toTeacher(id, updateTeacherRequest);
        final var updatedTeacher = updateTeacherUseCase.update(teacher);
        return teacherMapper.fromDomain(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final String id) {
        deleteTeacherUseCase.deleteBy(id);
    }

}

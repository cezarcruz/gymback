package br.com.cezarcruz.gymback.teacher.domain.usecase;

import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;

public interface CreateTeacherUseCase {
    Teacher create(Teacher teacher);
}

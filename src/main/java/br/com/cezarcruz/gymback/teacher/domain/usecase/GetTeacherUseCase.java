package br.com.cezarcruz.gymback.teacher.domain.usecase;

import br.com.cezarcruz.gymback.teacher.domain.model.Teacher;

import java.util.stream.Stream;

public interface GetTeacherUseCase {

    Stream<Teacher> getAll();

}

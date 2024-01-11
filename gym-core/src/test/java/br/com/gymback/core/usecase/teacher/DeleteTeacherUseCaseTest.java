package br.com.gymback.core.usecase.teacher;

import static org.mockito.Mockito.verify;

import br.com.gymback.core.gateway.teacher.DeleteTeacherGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeleteTeacherUseCaseTest {

  @Mock
  private DeleteTeacherGateway teacherGateway;

  @InjectMocks
  private DeleteTeacherUseCase deleteTeacherUseCase;

  @Test
  void shouldDeleteTeacher() {
    deleteTeacherUseCase.deleteBy(123L);

    verify(teacherGateway).deleteTeacher(123L);
  }

}
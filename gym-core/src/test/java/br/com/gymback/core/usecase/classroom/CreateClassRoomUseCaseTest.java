/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.classroom;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.exceptions.TeacherNotFountException;
import br.com.gymback.core.fixtures.ClassRoomFixtures;
import br.com.gymback.core.gateway.classroom.SaveClassRoomGateway;
import br.com.gymback.core.gateway.modality.GetModalityGateway;
import br.com.gymback.core.gateway.teacher.GetTeacherGateway;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CreateClassRoomUseCaseTest {

  @Mock private GetTeacherGateway getTeacherGateway;

  @Mock private SaveClassRoomGateway saveClassRoomGateway;

  @Mock private GetModalityGateway getModalityGateway;

  @InjectMocks private CreateClassRoomUseCase createClassRoomUseCase;

  @Test
  void shouldNotFindTeacher() {
    when(getTeacherGateway.findById(any())).thenReturn(Optional.empty());

    final ClassRoomDomain classRoom = ClassRoomFixtures.getClassRoom();

    assertThatThrownBy(() -> createClassRoomUseCase.create(classRoom))
        .hasMessage(String.format("teacher %s not found", classRoom.teacher().id()))
        .isInstanceOf(TeacherNotFountException.class);

    verify(getTeacherGateway).findById(any());
    verifyNoInteractions(getModalityGateway);
    verifyNoInteractions(saveClassRoomGateway);
  }
}

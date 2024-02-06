/* Under MIT License (C)2024 */
package br.com.gymback.core.usecase.classroom;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.exceptions.ModalityNotFountException;
import br.com.gymback.core.exceptions.TeacherNotFountException;
import br.com.gymback.core.gateway.classroom.SaveClassRoomGateway;
import br.com.gymback.core.gateway.modality.GetModalityGateway;
import br.com.gymback.core.gateway.schedule.SaveScheduleGateway;
import br.com.gymback.core.gateway.teacher.GetTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateClassRoomUseCase {

  private final SaveClassRoomGateway saveClassRoomGateway;
  private final GetTeacherGateway getTeacherGateway;
  private final GetModalityGateway getModalityGateway;
  private final SaveScheduleGateway saveScheduleGateway;

  public ClassRoomDomain create(final ClassRoomDomain classRoom) {

    var classRoomWithTeacher =
        getTeacherGateway
            .findById(classRoom.teacher().id())
            .map(classRoom::withTeacher)
            .orElseThrow(() -> new TeacherNotFountException(classRoom.teacher().id()));

    var validClassRoom =
        getModalityGateway
            .findById(classRoom.modality().id())
            .map(classRoomWithTeacher::withModality)
            .orElseThrow(() -> new ModalityNotFountException(classRoom.modality().id()));

    var schedules = saveScheduleGateway.save(classRoom.schedule());

    return saveClassRoomGateway.save(validClassRoom.withSchedule(schedules));
  }
}

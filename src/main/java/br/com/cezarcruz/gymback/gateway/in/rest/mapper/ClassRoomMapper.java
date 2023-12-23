package br.com.cezarcruz.gymback.gateway.in.rest.mapper;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.request.CreateClassRoomRequest;
import br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ClassRoomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = ComponentModel.JAKARTA,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {ModalityMapper.class, TeacherMapper.class}
)
public interface ClassRoomMapper {

  @Mapping(target = "teacher.id", source = "teacher")
  @Mapping(target = "modality.id", source = "modality")
  ClassRoom from(final CreateClassRoomRequest createClassRoomRequest);
  ClassRoomResponse from(final ClassRoom classRoom);

}

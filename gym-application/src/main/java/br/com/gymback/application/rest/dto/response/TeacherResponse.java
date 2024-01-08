package br.com.gymback.application.rest.dto.response;

import java.time.LocalDate;
import java.util.List;

public record TeacherResponse(
    String id,
    String name,
    LocalDate birthDate,
    List<ContactResponse> contacts
) {

}

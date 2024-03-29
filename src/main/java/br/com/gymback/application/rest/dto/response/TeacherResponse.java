/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.dto.response;

import java.time.LocalDate;

public record TeacherResponse(
    String id, String name, LocalDate birthDate, ContactResponse contact) {}

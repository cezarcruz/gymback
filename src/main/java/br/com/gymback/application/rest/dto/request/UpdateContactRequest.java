/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record UpdateContactRequest(@NotNull String email, @NotNull String phone) {}

/* Under MIT License (C)2024 */
package br.com.gymback.core.domain;

import lombok.Builder;

@Builder
public record ModalityDomain(Long id, String name) implements GenericDomain {}

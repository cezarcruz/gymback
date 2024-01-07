package br.com.cezarcruz.gymback.core.gateway;

import java.util.Optional;
import java.util.stream.Stream;

public interface GetGateway<T> {
  Stream<T> findAll();
  Optional<T> findById(final String id);
}

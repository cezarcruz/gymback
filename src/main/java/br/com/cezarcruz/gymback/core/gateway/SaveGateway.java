package br.com.cezarcruz.gymback.core.gateway;

public interface SaveGateway<T> {
  T save(final T model);
}

package br.com.gymback.core.gateway;

public interface SaveGateway<T> {
  T save(final T model);
}

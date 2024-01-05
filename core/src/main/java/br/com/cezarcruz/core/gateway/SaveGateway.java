package br.com.cezarcruz.core.gateway;

public interface SaveGateway<T> {
  T save(final T model);
}

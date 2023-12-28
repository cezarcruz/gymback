package br.com.cezarcruz.gymback.gateway.out.gateway;

public interface SaveGateway<T> {
  T save(final T model);
}

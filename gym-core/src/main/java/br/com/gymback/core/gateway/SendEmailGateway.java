package br.com.gymback.core.gateway;

public interface SendEmailGateway {
  void send(String email, String template);
}

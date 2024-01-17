/* Under MIT License (C)2024 */
package br.com.gymback.core.gateway;

public interface SendEmailGateway {
  void send(String email, String template);
}

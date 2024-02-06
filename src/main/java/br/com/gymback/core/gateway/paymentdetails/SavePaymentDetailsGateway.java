/* Under MIT License (C)2024 */
package br.com.gymback.core.gateway.paymentdetails;

import br.com.gymback.core.domain.PaymentDetailsDomain;

public interface SavePaymentDetailsGateway {
  PaymentDetailsDomain save(final PaymentDetailsDomain paymentDetails);
}

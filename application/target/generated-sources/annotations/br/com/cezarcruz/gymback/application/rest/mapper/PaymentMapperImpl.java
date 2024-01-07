package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.response.PaymentResponse;
import br.com.cezarcruz.gymback.core.domain.PaymentDomain;
import br.com.cezarcruz.gymback.core.enums.PaymentType;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T20:19:33-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Singleton
@Named
public class PaymentMapperImpl implements PaymentMapper {

    @Override
    public PaymentResponse fromModel(PaymentDomain source) {
        if ( source == null ) {
            return null;
        }

        String id = null;
        BigDecimal value = null;
        LocalDate paymentDay = null;
        PaymentType paymentType = null;

        id = source.id();
        value = source.value();
        paymentDay = source.paymentDay();
        paymentType = source.paymentType();

        PaymentResponse paymentResponse = new PaymentResponse( id, value, paymentDay, paymentType );

        return paymentResponse;
    }
}

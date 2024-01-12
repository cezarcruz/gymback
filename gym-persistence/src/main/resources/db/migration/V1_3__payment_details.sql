CREATE TABLE IF NOT EXISTS payment_details (
  id bigint auto_increment not null,
  payment_id bigint not null,
  payment_method bigint not null,
  value decimal(10,2) not null,
  paid_value decimal(10,2) not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT payment_details_pk PRIMARY KEY (id)
);

ALTER TABLE payment_details ADD CONSTRAINT payment_payment_fk FOREIGN KEY (payment_id) REFERENCES payment(id);

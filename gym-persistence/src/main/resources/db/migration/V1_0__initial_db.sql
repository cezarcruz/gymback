CREATE TABLE IF NOT EXISTS week_day (
	name varchar(3) NOT NULL,
	label varchar(15) NOT NULL,
	CONSTRAINT week_day_pk PRIMARY KEY (name)
);

CREATE TABLE IF NOT EXISTS modality (
  id varchar(36),
  name varchar(50),
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT modality_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS teacher (
  id varchar(36),
  name varchar(50) not null,
  birth_date date not null,
  contact_id varchar(36),
  address_id varchar(36),
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT teacher_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS student (
  id varchar(36),
  name varchar(50) not null,
  document varchar(20),
  contact_id varchar(36),
  address_id varchar(36),
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT student_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS class_room (
  id varchar(36),
  name varchar(50) not null,
  modality_id varchar(36),
  teacher_id varchar(36),
  value decimal(10,2) not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT class_room_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS address (
  id varchar(36),
  zipcode varchar(8) not null,
  street varchar(200) not null,
  neighborhood varchar(100) not null,
  city varchar(100),
  state varchar(2),
  address_number varchar(6) not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT address_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contact (
  id varchar(36),
  phone varchar(15),
  email varchar(100),
  created_at timestamp not null,
  updated_at timestamp not null,

  CONSTRAINT contact_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS payment (
  id varchar(36),
  value decimal(10,2) not null,
  payment_day date not null,
  payment_type ENUM('IN', 'OUT'),
  payment_status ENUM('PAID', 'PENDING', 'OVERDUE'),
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT payment_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contract (
  id varchar(36),
  start_month varchar(15),
  end_month varchar(15),
  start_year numeric(4),
  end_year numeric(4),
  due_day numeric(2),
  contract_type ENUM('MONTHLY', 'YEARLY'),
  contract_status ENUM('SUSPENDED', 'ACTIVE', 'FINISHED'),
  student_id varchar(36),
  class_room_id varchar(36),
  CONSTRAINT class_room_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contract_payment (
  contract_id varchar(36) not null,
  payment_id varchar(36) not null
);

CREATE TABLE IF NOT EXISTS schedule (
  id varchar(36),
  week_day varchar(3) not null,
  start_hour time not null,
  end_hour time not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT class_room_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS class_room_schedule (
  class_room_id varchar(36) NOT NULL,
  schedule_id varchar(36) NOT NULL
);
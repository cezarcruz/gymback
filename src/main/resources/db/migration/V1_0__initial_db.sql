CREATE TABLE IF NOT EXISTS week_day (
	name varchar(3) NOT NULL,
	label varchar(15) NOT NULL,
  created_at timestamp not null,
  updated_at timestamp not null,
	CONSTRAINT week_day_pk PRIMARY KEY (name)
);

CREATE TABLE IF NOT EXISTS modality (
  id bigint auto_increment not null,
  name varchar(50),
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT modality_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS teacher (
  id bigint auto_increment not null,
  name varchar(50) not null,
  birth_date date not null,
  contact_id bigint not null,
  address_id bigint,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT teacher_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS student (
  id bigint auto_increment not null,
  name varchar(50) not null,
  document varchar(20),
  birth_date date not null,
  contact_id bigint not null,
  address_id bigint not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT student_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS class_room (
  id bigint auto_increment not null,
  name varchar(50) not null,
  modality_id bigint not null,
  teacher_id bigint not null,
  value decimal(10,2) not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT class_room_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS address (
  id bigint auto_increment not null,
  zipcode varchar(9) not null, -- redo
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
  id bigint auto_increment not null,
  phone varchar(30), -- redo
  email varchar(100),
  created_at timestamp not null,
  updated_at timestamp not null,

  CONSTRAINT contact_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS payment (
  id bigint auto_increment not null,
  value decimal(10,2) not null,
  payment_day date not null,
  payment_type ENUM('IN', 'OUT'),
  payment_status ENUM('PAID', 'PENDING', 'OVERDUE'),
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT payment_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contract (
  id bigint auto_increment not null,
  start_month varchar(15),
  end_month varchar(15),
  start_year numeric(4),
  end_year numeric(4),
  due_day numeric(2),
  discount decimal(10,2),
  contract_type ENUM('MONTHLY', 'YEARLY'),
  contract_status ENUM('SUSPENDED', 'ACTIVE', 'FINISHED'),
  student_id bigint not null,
  class_room_id bigint not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT class_room_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS contract_payment (
  contract_id bigint not null,
  payment_id bigint not null
);

CREATE TABLE IF NOT EXISTS schedule (
  id bigint auto_increment not null,
  week_day varchar(3) not null,
  start_hour time not null,
  end_hour time not null,
  created_at timestamp not null,
  updated_at timestamp not null,
  CONSTRAINT class_room_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS class_room_schedule (
  class_room_id bigint NOT NULL,
  schedule_id bigint NOT NULL
);
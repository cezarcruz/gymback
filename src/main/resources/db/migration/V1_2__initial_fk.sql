ALTER TABLE schedule ADD CONSTRAINT schedule_week_day_fk FOREIGN KEY (week_day) REFERENCES week_day(name);

ALTER TABLE teacher ADD CONSTRAINT teacher_contact_fk FOREIGN KEY (contact_id) REFERENCES contact(id);
ALTER TABLE teacher ADD CONSTRAINT teacher_address_fk FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE student ADD CONSTRAINT student_contact_fk FOREIGN KEY (contact_id) REFERENCES contact(id);
ALTER TABLE student ADD CONSTRAINT student_address_fk FOREIGN KEY (address_id) REFERENCES address(id);

ALTER TABLE class_room ADD CONSTRAINT class_modality_fk FOREIGN KEY (modality_id) REFERENCES modality(id);
ALTER TABLE class_room ADD CONSTRAINT class_teacher_fk FOREIGN KEY (teacher_id) REFERENCES teacher(id);

ALTER TABLE class_room_schedule ADD CONSTRAINT class_room_schedule_schedule_fk FOREIGN KEY (schedule_id) REFERENCES schedule (id);
ALTER TABLE class_room_schedule ADD CONSTRAINT class_room_schedule_class_room_fk FOREIGN KEY (class_room_id) REFERENCES class_room (id);

ALTER TABLE contract ADD CONSTRAINT contract_student_fk FOREIGN KEY (student_id) REFERENCES student(id);
ALTER TABLE contract ADD CONSTRAINT contract_class_room_fk FOREIGN KEY (class_room_id) REFERENCES class_room(id);

ALTER TABLE contract_payment ADD CONSTRAINT contract_payment_contract_fk FOREIGN KEY (contract_id) REFERENCES contract(id);
ALTER TABLE contract_payment ADD CONSTRAINT contract_payment_payment_fk FOREIGN KEY (payment_id) REFERENCES payment(id);
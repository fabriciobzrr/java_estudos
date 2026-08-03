INSERT INTO tb_category(description) VALUES ('Curso');
INSERT INTO tb_category(description) VALUES ('Oficina');

INSERT INTO tb_activity(name, description, price, category_id) VALUES ('Curso de JavaScript', 'Aprenda JavaScript do zero ao avançado', '100.00' ,'1');
INSERT INTO tb_activity(name, description, price, category_id) VALUES ('Oficina de Docker', 'Desvende os mistérios do Docker e facilite o desenvolvimento de suas aplicações', '200.00' ,'2');

INSERT INTO tb_block(start_hour, end_hour, activity_id) VALUES ('2026-08-20T08:00:00Z', '2026-08-20T12:00:00Z', '1');
INSERT INTO tb_block(start_hour, end_hour, activity_id) VALUES ('2026-08-20T14:00:00Z', '2026-08-20T18:00:00Z', '1');
INSERT INTO tb_block(start_hour, end_hour, activity_id) VALUES ('2026-08-21T09:00:00Z', '2026-08-21T13:00:00Z', '2');
INSERT INTO tb_block(start_hour, end_hour, activity_id) VALUES ('2026-08-21T15:00:00Z', '2026-08-21T17:00:00Z', '2');

INSERT INTO tb_participant(name, email) VALUES ('Fabricio Bezerra', 'fab@g.c');
INSERT INTO tb_participant(name, email) VALUES ('Fred Santos', 'frd@g.c');
INSERT INTO tb_participant(name, email) VALUES ('Billy Heifer', 'blly@g.c');
INSERT INTO tb_participant(name, email) VALUES ('Billy Boy', 'bby@g.c');

INSERT INTO tb_participant_activity(participant_id, activity_id) VALUES ('1', '1');
INSERT INTO tb_participant_activity(participant_id, activity_id) VALUES ('1', '2');
INSERT INTO tb_participant_activity(participant_id, activity_id) VALUES ('2', '1');
INSERT INTO tb_participant_activity(participant_id, activity_id) VALUES ('3', '2');
INSERT INTO tb_participant_activity(participant_id, activity_id) VALUES ('4', '1');
INSERT INTO tb_participant_activity(participant_id, activity_id) VALUES ('4', '2');
-- V3__add_id_column_and_update_users.sql

-- Adiciona a coluna ID auto-incremental iniciando em 1000
ALTER TABLE TB_USERS ADD COLUMN user_code BIGSERIAL;

-- Atualiza os inserts para incluir o novo campo ID
DELETE FROM TB_USERS;

INSERT INTO TB_USERS (user_id, user_code, name, email) VALUES
  ('11111111-1111-1111-1111-111111111111', 1000, 'Alice Silva', 'alice.silva@email.com'),
  ('22222222-2222-2222-2222-222222222222', 1001, 'Bruno Souza', 'bruno.souza@email.com'),
  ('33333333-3333-3333-3333-333333333333', 1002, 'Carla Lima', 'carla.lima@email.com');

-- Atualiza o valor inicial da sequência para 1002
ALTER SEQUENCE tb_users_user_code_seq RESTART WITH 1003;




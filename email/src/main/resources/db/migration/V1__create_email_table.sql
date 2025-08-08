CREATE TABLE IF NOT EXISTS email_entity (
    email_id UUID PRIMARY KEY,
    user_id UUID,
    email_from VARCHAR(255),
    email_to VARCHAR(255),
    email_subject VARCHAR(255),
    body TEXT,
    send_date_email TIMESTAMP,
    email_status VARCHAR(20)
);

INSERT INTO email_entity (
    email_id, user_id, email_from, email_to, email_subject, body, send_date_email, email_status
) VALUES (
    '11111111-1111-1111-1111-111111111111',
    '22222222-2222-2222-2222-222222222222',
    'teste@email.com',
    'destino@email.com',
    'Assunto de Teste',
    'Corpo do e-mail de teste',
    NOW(),
    'SENT'
);


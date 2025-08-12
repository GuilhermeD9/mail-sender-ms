CREATE TABLE scheduling_entity (
    scheduling_id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    professional_id UUID NOT NULL,
    scheduling_date DATE NOT NULL,
    scheduling_time TIME NOT NULL,
    scheduling_status VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO scheduling_entity (scheduling_id, user_id, professional_id, scheduling_date, scheduling_time, scheduling_status, description) VALUES
    ('11111111-1111-1111-1111-111111111111', '22222222-2222-2222-2222-222222222222', '33333333-3333-3333-3333-333333333333', '2025-08-11', '10:00:00', 'PENDING', 'Initial consultation'),
    ('44444444-4444-4444-4444-444444444444', '55555555-5555-5555-5555-555555555555', '66666666-6666-6666-6666-666666666666', '2025-08-12', '14:30:00', 'CONFIRMED', 'Confirmed Work'),
    ('77777777-7777-7777-7777-777777777777', '88888888-8888-8888-8888-888888888888', '99999999-9999-9999-9999-999999999999', '2025-08-13', '09:15:00', 'CANCELLED', 'Cancelled Appointment');

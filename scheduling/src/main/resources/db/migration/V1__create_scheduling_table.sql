CREATE TABLE scheduling_entity (
    scheduling_id UUID PRIMARY KEY,
    user_code INTEGER NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    professional_code INTEGER NOT NULL,
    professional_email VARCHAR(255) NOT NULL,
    scheduling_date DATE NOT NULL,
    scheduling_time TIME NOT NULL,
    scheduling_status VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

INSERT INTO scheduling_entity (
    scheduling_id, user_code, user_email, professional_code, professional_email, scheduling_date, scheduling_time, scheduling_status, description
) VALUES
    ('11111111-1111-1111-1111-111111111111', 1001, 'user1@email.com', 2001, 'prof1@email.com', '2025-08-11', '10:00:00', 'PENDING', 'Initial consultation'),
    ('44444444-4444-4444-4444-444444444444', 1002, 'user2@email.com', 2002, 'prof2@email.com', '2025-08-12', '14:30:00', 'CONFIRMED', 'Confirmed Work'),
    ('77777777-7777-7777-7777-777777777777', 1003, 'user3@email.com', 2003, 'prof3@email.com', '2025-08-13', '09:15:00', 'CANCELLED', 'Cancelled Appointment');

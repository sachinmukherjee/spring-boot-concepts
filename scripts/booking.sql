CREATE TABLE bookings (
    id CHAR(36) PRIMARY KEY,
    item_id CHAR(36) NOT NULL,
    customer_id CHAR(36) NOT NULL,
    start_date DATETIME NOT NULL,
    end_date DATETIME NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME
);
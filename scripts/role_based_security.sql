CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE user_roles (
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE
);

CREATE TABLE permissions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE role_permissions (
    role_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (role_id, permission_id),
    FOREIGN KEY (role_id) REFERENCES roles(id) ON DELETE CASCADE,
    FOREIGN KEY (permission_id) REFERENCES permissions(id) ON DELETE CASCADE
);


-- Data
INSERT INTO permissions (name) VALUES
('READ_PRIVILEGES'),
('WRITE_PRIVILEGES'),
('DELETE_PRIVILEGES'),
('ADMIN_PRIVILEGES');

-- 2️⃣ Insert Roles
INSERT INTO roles (name) VALUES
('ADMIN'),
('USER'),
('MANAGER'),
('SUPPORT'),
('DEVELOPER');

-- 3️⃣ Assign Permissions to Roles
-- Admin gets all permissions
INSERT INTO role_permissions (role_id, permission_id) VALUES
(1, 1), (1, 2), (1, 3), (1, 4);

-- User gets only read permission
INSERT INTO role_permissions (role_id, permission_id) VALUES
(2, 1);

-- Manager gets read and write
INSERT INTO role_permissions (role_id, permission_id) VALUES
(3, 1), (3, 2);

-- Support gets only read and delete permissions
INSERT INTO role_permissions (role_id, permission_id) VALUES
(4, 1), (4, 3);

-- Developer gets read and write permissions
INSERT INTO role_permissions (role_id, permission_id) VALUES
(5, 1), (5, 2);

-- 4️⃣ Insert Users (Passwords are hashed using BCrypt)
INSERT INTO users (username, password, enabled) VALUES
('john_admin', '$2a$10$9q4r3WxZ/h6zidq5YPQH5unHQ73Rjb8TbQJzB/wR3ChCvrkOsEYqK', 1), -- admin123
('alice_user', '$2a$10$yH3mBqHtY8hlFzH3lFMLjOvuOmSStnL8D8J7qAL3PB/1Ub5ns9d9G', 1), -- user123
('bob_user', '$2a$10$yH3mBqHtY8hlFzH3lFMLjOvuOmSStnL8D8J7qAL3PB/1Ub5ns9d9G', 1), -- user123
('david_manager', '$2a$10$3FvX2MDmO8i2PTpXMQO1fu2FSvlZZdH7A6xuoS/5smGFtkWQ4fPym', 1), -- manager123
('emily_manager', '$2a$10$3FvX2MDmO8i2PTpXMQO1fu2FSvlZZdH7A6xuoS/5smGFtkWQ4fPym', 1), -- manager123
('sophia_support', '$2a$10$d8FQF/nmHzsBwREUMyo5eOYwOIVMlS7o3X6yxZHvZJizDbXh7I5ZK', 1), -- support123
('michael_support', '$2a$10$d8FQF/nmHzsBwREUMyo5eOYwOIVMlS7o3X6yxZHvZJizDbXh7I5ZK', 1), -- support123
('chris_dev', '$2a$10$Z0QgBpGHHfEqnPAyYQaZc.AjdMtGDbEQi/SUlEVdEYkCMxy3llf7m', 1), -- dev123
('olivia_dev', '$2a$10$Z0QgBpGHHfEqnPAyYQaZc.AjdMtGDbEQi/SUlEVdEYkCMxy3llf7m', 1), -- dev123
('james_dev', '$2a$10$Z0QgBpGHHfEqnPAyYQaZc.AjdMtGDbEQi/SUlEVdEYkCMxy3llf7m', 1); -- dev123

-- 5️⃣ Assign Roles to Users
INSERT INTO user_roles (user_id, role_id) VALUES
(1, 1),  -- john_admin -> ADMIN
(2, 2),  -- alice_user -> USER
(3, 2),  -- bob_user -> USER
(4, 3),  -- david_manager -> MANAGER
(5, 3),  -- emily_manager -> MANAGER
(6, 4),  -- sophia_support -> SUPPORT
(7, 4),  -- michael_support -> SUPPORT
(8, 5),  -- chris_dev -> DEVELOPER
(9, 5),  -- olivia_dev -> DEVELOPER
(10, 5); -- james_dev -> DEVELOPER
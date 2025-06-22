-- DB Relationships
-- One to One

drop table if exists student;
drop table if exists student_id_card;

CREATE TABLE student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    course VARCHAR(100),
    created_by varchar(100) not null,
    created_date timestamp not null default current_timestamp
);

create table student_id_card(
	id bigint primary key auto_increment,
	card_number varchar(30) not null unique,
	issue_date date not null,
	student_id bigint unique,
	constraint pk_student_card foreign key(student_id)
	references student(id)
	on delete cascade
);
-- One to Many


-- Many to Many
/*
-- Orders table
CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_name VARCHAR(100),
    order_date DATE
);

-- Items table
CREATE TABLE Items (
    item_id INT PRIMARY KEY,
    item_name VARCHAR(100),
    price DECIMAL(10, 2)
);

-- OrderItem table with composite primary key and indexes
CREATE TABLE OrderItem (
    order_id INT NOT NULL,
    item_id INT NOT NULL,
    quantity INT,
    discount DECIMAL(5,2),
    PRIMARY KEY (order_id, item_id),  -- Composite Primary Key

    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (item_id) REFERENCES Items(item_id)
);

-- Index to speed up lookups by item_id
CREATE INDEX idx_orderitem_itemid ON OrderItem(item_id);

-- Index to optimize queries filtering by quantity
CREATE INDEX idx_orderitem_quantity ON OrderItem(quantity);

-- Composite index on (item_id, quantity) to support combined filter
CREATE INDEX idx_orderitem_itemid_quantity ON OrderItem(item_id, quantity);
*/




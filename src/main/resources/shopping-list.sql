DROP TABLE IF EXISTS shopping_items;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    user_id SERIAL,
    user_name varchar(20) not null,
    user_password varchar(100) not null,
    PRIMARY KEY (user_id),
    UNIQUE (user_name)
);

CREATE TABLE shopping_items
(
    shopping_item_id SERIAL,
    shopping_item_name varchar(100) not null,
    shopping_item_user_id integer not null,
    PRIMARY KEY (shopping_item_id),
    FOREIGN KEY (shopping_item_user_id) REFERENCES users(user_id) ON DELETE RESTRICT
);

CREATE INDEX idx_user_id ON users(user_id);
CREATE INDEX idx_shopping_item_id ON shopping_items(shopping_item_id);
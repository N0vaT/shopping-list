DROP TABLE IF EXISTS shopping_items;

CREATE TABLE shopping_items
(
    shopping_item_id SERIAL,
    shopping_item_name varchar(100) not null,
    PRIMARY KEY (shopping_item_id)
);
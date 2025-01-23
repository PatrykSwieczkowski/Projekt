

CREATE TABLE IF NOT EXISTS nutrition (
                                         id INT PRIMARY KEY,
                                         calories INT,
                                         protein VARCHAR(10),
                                         fat VARCHAR(10),
                                         carbs VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS ingredient (
                                          id INT PRIMARY KEY AUTO_INCREMENT,
                                          name VARCHAR(50),
                                          amount VARCHAR(10),
                                          unit VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS recipe (
                                      id INT PRIMARY KEY AUTO_INCREMENT,
                                      title VARCHAR(100),
                                      ready_in_minutes INT,
                                      summary TEXT,
                                      image VARCHAR(100),
                                      consistency VARCHAR(20),
                                      servings INT,
                                      nutrition_id INT,
                                      FOREIGN KEY (nutrition_id) REFERENCES nutrition(id)
);
INSERT IGNORE INTO nutrition (id, calories, protein, fat, carbs)
VALUES (2, 200, '5g', '10g', '20g');

INSERT IGNORE INTO nutrition (id, calories, protein, fat, carbs)
VALUES (3, 150, '3g', '5g', '25g');

INSERT IGNORE INTO nutrition (id, calories, protein, fat, carbs)
VALUES (4, 300, '8g', '15g', '35g');

INSERT IGNORE INTO nutrition (id, calories, protein, fat, carbs)
VALUES (5, 100, '2g', '2g', '10g');


INSERT INTO ingredient (id, name, amount, unit)
SELECT 1, 'Salt', '1', 'tsp'
    WHERE NOT EXISTS (SELECT 1 FROM ingredient WHERE name = 'Salt');

INSERT INTO ingredient (id, name, amount, unit)
SELECT 2, 'Sugar', '2', 'tbsp'
    WHERE NOT EXISTS (SELECT 1 FROM ingredient WHERE name = 'Sugar');

INSERT INTO ingredient (id,name, amount, unit)
SELECT 3,'Flour', '500', 'g'
    WHERE NOT EXISTS (SELECT 1 FROM ingredient WHERE name = 'Flour');

INSERT INTO ingredient (id, name, amount, unit)
SELECT 4,'Eggs', '3', 'pieces'
    WHERE NOT EXISTS (SELECT 1 FROM ingredient WHERE name = 'Eggs');

INSERT INTO ingredient (name, amount, unit)
SELECT 'Milk', '250', 'ml'
    WHERE NOT EXISTS (SELECT 1 FROM ingredient WHERE name = 'Milk');


INSERT IGNORE INTO nutrition (id, calories, protein, fat, carbs)
VALUES (1, 200, '5g', '10g', '20g');

INSERT IGNORE INTO recipe (title, ready_in_minutes, summary, image, consistency, servings, nutrition_id)
VALUES ('Pancakes', 20, 'Delicious fluffy pancakes', 'pancakes.jpg', 'solid', 4, 1);












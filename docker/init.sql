INSERT INTO users
VALUES (1, 'Alex', 2);

INSERT INTO users
VALUES (2, 'Paul', 0);

INSERT INTO users
VALUES (3, 'Mike', 1);

INSERT INTO users
VALUES (4, 'Steve', 1);

SELECT setval('users_seq', 100, true);

INSERT INTO posts
VALUES (1, 1, 'Hi friends, I recently watched amazing movie at the cinema', '2023-04-21');

INSERT INTO posts
VALUES (2, 1, 'Hi friends, I changed the topic of my post', '2023-04-23');

INSERT INTO posts
VALUES (3, 3, 'Hi friends, I changed the topic of my post', '2023-04-19');

INSERT INTO posts
VALUES (4, 4, 'Hi friends, I recently watched amazing movie at the cinema', '2023-02-01');

SELECT setval('posts_seq', 100, true);

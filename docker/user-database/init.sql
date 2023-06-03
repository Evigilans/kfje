INSERT INTO users
VALUES (1, 'Alex', 2);

INSERT INTO users
VALUES (2, 'Paul', 0);

INSERT INTO users
VALUES (3, 'Mike', 1);

INSERT INTO users
VALUES (4, 'Steve', 1);

SELECT setval('users_seq', 100, true);
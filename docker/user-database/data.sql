CREATE TABLE IF NOT EXISTS users
(
    user_id         bigint        NOT NULL,
    username        varchar(40)   NOT NULL,
    amount_of_posts int DEFAULT 0 NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
);

ALTER TABLE users
    OWNER TO postgres;

CREATE SEQUENCE users_seq INCREMENT BY 50;

ALTER SEQUENCE users_seq OWNER TO postgres;

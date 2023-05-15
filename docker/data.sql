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

CREATE TABLE IF NOT EXISTS posts
(
    post_id   bigint                    NOT NULL,
    author_id bigint                    NOT NULL,
    text      text                      NOT NULL,
    posted_at date DEFAULT CURRENT_DATE NOT NULL,
    CONSTRAINT posts_pkey PRIMARY KEY (post_id)
);

ALTER TABLE posts
    OWNER TO postgres;

CREATE SEQUENCE posts_seq INCREMENT BY 50;

ALTER SEQUENCE posts_seq OWNER TO postgres;

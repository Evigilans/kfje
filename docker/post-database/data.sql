CREATE TABLE IF NOT EXISTS posts
(
    post_id   bigint                                             NOT NULL,
    author_id bigint                                             NOT NULL,
    text      text                                               NOT NULL,
    posted_at timestamp WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT posts_pkey PRIMARY KEY (post_id)
);

ALTER TABLE posts
    OWNER TO postgres;

CREATE SEQUENCE posts_seq INCREMENT BY 50;

ALTER SEQUENCE posts_seq OWNER TO postgres;

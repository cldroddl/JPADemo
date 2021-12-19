CREATE TABLE apply_position
(
    id           BIGINT  NOT NULL,
    apply_status INTEGER,
    need_1       BOOLEAN NOT NULL,
    need_2       BOOLEAN NOT NULL,
    developer_id BIGINT,
    position_id  BIGINT,
    CONSTRAINT pk_apply_position PRIMARY KEY (id)
);

CREATE TABLE developer
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_developer PRIMARY KEY (id)
);

CREATE TABLE project
(
    id   BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_project PRIMARY KEY (id)
);

CREATE TABLE project_position
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255),
    project_id BIGINT,
    CONSTRAINT pk_project_position PRIMARY KEY (id)
);

ALTER TABLE apply_position
    ADD CONSTRAINT FK_APPLY_POSITION_ON_DEVELOPER FOREIGN KEY (developer_id) REFERENCES developer (id);

ALTER TABLE apply_position
    ADD CONSTRAINT FK_APPLY_POSITION_ON_POSITION FOREIGN KEY (position_id) REFERENCES project_position (id);

ALTER TABLE project_position
    ADD CONSTRAINT FK_PROJECT_POSITION_ON_PROJECT FOREIGN KEY (project_id) REFERENCES project (id);
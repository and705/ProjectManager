INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO projects (parent_project_id, root_project_id,  title)
VALUES (NULL, NULL, 'Проект 1');
INSERT INTO projects (parent_project_id, root_project_id,  title)
VALUES (NULL, NULL, 'Проект 2');
INSERT INTO projects (parent_project_id, root_project_id,  title)
VALUES (2, 2, 'Проект 2.1');
INSERT INTO projects (parent_project_id, root_project_id,  title)
VALUES (2, 2, 'Проект 2.2');
INSERT INTO projects (parent_project_id, root_project_id,  title)
VALUES (2, 4, 'Проект 2.2.1');
INSERT INTO projects (parent_project_id, root_project_id,  title)
VALUES (2, 4, 'Проект 2.2.2');

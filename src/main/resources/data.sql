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

INSERT INTO tasks (    task_date_of_create,
                       task_info,
                       task_name,
                       task_owner,
                       task_status,
                       task_type,
                       project_id)
VALUES ('2023-03-09 02:59:54.600256',
        'Опмсание задачи',
        'Задача 1',
        'admin',
        'new',
        'для менеджера',
        1);
INSERT INTO tasks (    task_date_of_create,
                       task_info,
                       task_name,
                       task_owner,
                       task_status,
                       task_type,
                       project_id)
VALUES ('2023-03-09 02:59:54.600256',
        'Опмсание задачи',
        'Задача 2',
        'user',
        'new',
        'для менеджера',
        1);
INSERT INTO tasks (    task_date_of_create,
                       task_info,
                       task_name,
                       task_owner,
                       task_status,
                       task_type,
                       project_id)
VALUES ('2023-03-09 02:59:54.600256',
        'Опмсание задачи',
        'Задача 3',
        'admin',
        'new',
        'для менеджера',
        4);

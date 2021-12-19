insert into project(id, name) values (1, 'pjt_1');
insert into project(id, name) values (2, 'pjt_2');
insert into project(id, name) values (3, 'pjt_3');

insert into project_position(id, name, project_id)
values (1, 'pjt1_pos1', 1);
insert into project_position(id, name, project_id)
values (2, 'pjt1_pos2', 1);
insert into project_position(id, name, project_id)
values (3, 'pjt1_pos3', 1);

insert into project_position(id, name, project_id)
values (4, 'pjt2_pos1', 2);
insert into project_position(id, name, project_id)
values (5, 'pjt2_pos2', 2);
insert into project_position(id, name, project_id)
values (6, 'pjt2_pos3', 2);

insert into project_position(id, name, project_id)
values (7, 'pjt3_pos1', 3);
insert into project_position(id, name, project_id)
values (8, 'pjt3_pos2', 3);
insert into project_position(id, name, project_id)
values (9, 'pjt3_pos3', 3);

insert into developer(id, name) values (1, 'dev1');
insert into developer(id, name) values (2, 'dev2');
insert into developer(id, name) values (3, 'dev3');
insert into developer(id, name) values (4, 'dev4');
insert into developer(id, name) values (5, 'dev5');
insert into developer(id, name) values (6, 'dev6');
insert into developer(id, name) values (7, 'dev7');
insert into developer(id, name) values (8, 'dev8');
insert into developer(id, name) values (9, 'dev9');
insert into developer(id, name) values (10, 'dev10');

insert into apply_position
    (id, apply_status, need_1, need_2, developer_id, position_id)
values
    (1, 1, true, true, 1, 1),
    (2, 1, true, true, 2, 1),
    (3, 1, true, true, 3, 1),
    (4, 0, true, false, 4, 2),
    (5, 1, true, false, 5, 4),
    (6, 1, true, false, 6, 5),
    (7, 1, true, false, 7, 6)
;
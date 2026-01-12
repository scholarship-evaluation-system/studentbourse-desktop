-- core

create table university (
                            id serial primary key,
                            name varchar(255) unique not null,
                            rank int
);

create table users (
                       id serial primary key,
                       role varchar(20) not null, -- student, evaluator, admin
                       first_name varchar(100) not null,
                       last_name varchar(100) not null,
                       email varchar(255) unique not null,
                       phone varchar(20),
                       password varchar(255) not null
);

create table scholarship (
                             id serial primary key,
                             title varchar(255) not null,
                             amount int not null,
                             deadline date not null,
                             max_applicants int not null,
                             level varchar(20) not null -- undergraduate, postgraduate, phd
);

create table scholarship_criteria (
                                      id serial primary key,
                                      scholarship_id int references scholarship(id) on delete cascade,
                                      academic_weight float default 0,
                                      financial_weight float default 0,
                                      exam_weight float default 0,
                                      extracurricular_weight float default 0,
                                      university_weight float default 0
);

-- application

create table application (
                             id serial primary key,
                             user_id int references users(id) on delete cascade,
                             scholarship_id int references scholarship(id) on delete cascade,
                             status varchar(30), -- submitted | in_process | picked | rejected
                             total_score float default 0,
                             comments text,
                             created_at timestamp default now()
);

create table document (
                          id serial primary key,
                          user_id int references users(id) on delete cascade,
                          application_id int references application(id) on delete cascade,
                          name varchar(255),
                          file_path text,
                          uploaded_at timestamp default now()
);

-- evaluation

create table evaluation (
                            id serial primary key,
                            application_id int references application(id) on delete cascade,
                            evaluator_id int references users(id),
                            academic_score float,
                            financial_score float,
                            exam_score float,
                            extracurricular_score float,
                            university_score float,
                            total_score float,
                            comments text,
                            evaluated_at timestamp default now()
);

create table application_preference (
                                        id serial primary key,
                                        application_id int references application(id) on delete cascade,
                                        priority int
);

-- stats

create table statistics_snapshot (
                                     id serial primary key,
                                     scholarship_id int references scholarship(id) on delete cascade,
                                     week int,
                                     students_awarded int,
                                     funds_awarded int,
                                     created_at timestamp default now()
);

-- sample data

insert into university (name, rank) values
                                        ('example university', 120),
                                        ('top tech institute', 25);

insert into scholarship (title, amount, deadline, max_applicants, level) values
                                                                             ('merit excellence award', 5000, '2026-06-30', 50, 'undergraduate'),
                                                                             ('global achiever scholarship', 8000, '2026-07-15', 30, 'postgraduate'),
                                                                             ('research fellowship', 12000, '2026-08-01', 10, 'phd');

insert into scholarship_criteria
(scholarship_id, academic_weight, financial_weight, exam_weight, extracurricular_weight, university_weight)
values
    (1, 30, 30, 20, 10, 10),
    (2, 35, 25, 20, 10, 10),
    (3, 40, 20, 20, 10, 10);

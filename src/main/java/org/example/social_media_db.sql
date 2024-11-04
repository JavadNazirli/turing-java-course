CREATE
DATABASE my_database IF NOT EXISTS;

CREATE TABLE users
(
    id              SERIAL PRIMARY KEY,
    username        VARCHAR(50)  NOT NULL UNIQUE,
    email_address   VARCHAR(100) NOT NULL UNIQUE,
    hashed_password CHAR(60)     NOT NULL,
    birth_date      DATE,
    role            VARCHAR(20)  NOT NULL DEFAULT 'regular_user',
    created_at      TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
    created_by      INT,
    updated_by      INT
);

CREATE TABLE posts
(
    id         SERIAL PRIMARY KEY,
    user_id    INT REFERENCES users (id) ON DELETE CASCADE,
    headline   VARCHAR(200) NOT NULL,
    body       TEXT         NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by INT,
    updated_by INT
);

CREATE TABLE comments
(
    id         SERIAL PRIMARY KEY,
    post_id    INT REFERENCES posts (id) ON DELETE CASCADE,
    user_id    INT  REFERENCES users (id) ON DELETE SET NULL,
    content    TEXT NOT NULL,
    approved   BOOLEAN   DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by INT,
    updated_by INT
);

CREATE TABLE likes
(
    id         SERIAL PRIMARY KEY,
    user_id    INT REFERENCES users (id) ON DELETE CASCADE,
    post_id    INT REFERENCES posts (id) ON DELETE CASCADE,
    comment_id INT REFERENCES comments (id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_like UNIQUE (user_id, post_id, comment_id)
);

INSERT INTO users (username, email_address, hashed_password, birth_date, role, created_by, updated_by)
VALUES ('aydan_aliyeva', 'aydan@example.com', 'hashedpassword1', '1992-03-15', 'regular_user', 1, 1),
       ('fuad_mammadov', 'fuad@example.com', 'hashedpassword2', '1988-06-10', 'regular_user', 1, 1),
       ('leyla_gasimova', 'leyla@example.com', 'hashedpassword3', '1995-09-22', 'admin', 1, 1),
       ('ramil_huseynov', 'ramil@example.com', 'hashedpassword4', '1990-01-30', 'regular_user', 1, 1),
       ('sabina_rahimova', 'sabina@example.com', 'hashedpassword5', '1987-12-05', 'super_admin', 1, 1),
       ('tofig_kerimov', 'tofig@example.com', 'hashedpassword6', '1993-04-18', 'regular_user', 1, 1),
       ('gunel_ismayilova', 'gunel@example.com', 'hashedpassword7', '1991-11-02', 'regular_user', 1, 1),
       ('ilkin_rustamov', 'ilkin@example.com', 'hashedpassword8', '1989-08-12', 'admin', 1, 1),
       ('narmin_abdullayeva', 'narmin@example.com', 'hashedpassword9', '1996-05-27', 'regular_user', 1, 1),
       ('taleh_novruzov', 'taleh@example.com', 'hashedpassword10', '1994-02-15', 'regular_user', 1, 1);
INSERT INTO posts (user_id, headline, body, created_by, updated_by)
VALUES (1, 'Azerbaycan Tarixi', 'Bu yazıda Azerbaycan tarixi haqqında məlumat verilir.', 1, 1),
       (2, 'Mədəniyyətimiz və Adət-ənənələrimiz', 'Azərbaycan mədəniyyəti və ənənələri haqqında maraqlı faktlar.', 2,
        2),
       (3, 'Qarabağın Dirçəlişi', 'Qarabağın yenidən qurulması barədə geniş məlumat.', 3, 3),
       (4, 'Novruz Bayramı', 'Novruz bayramının Azərbaycan üçün əhəmiyyəti.', 4, 4),
       (5, 'Azərbaycanın İqtisadi İnkişafı', 'Azərbaycanın iqtisadiyyatı haqqında son məlumatlar.', 5, 5),
       (6, 'Müasir İncəsənət', 'Azərbaycan incəsənətinin müasir dövrdəki rolu.', 6, 6),
       (7, 'Azərbaycan Mətbəxi', 'Milli mətbəximizin inciləri haqqında.', 7, 7),
       (8, 'Nizami Gəncəvi İli', 'Nizami Gəncəvinin anım ili çərçivəsində tədbirlər.', 8, 8),
       (9, 'Azərbaycanın Təbiəti', 'Azərbaycanın unikal təbiəti və milli parkları.', 9, 9),
       (10, 'Gənclər və İdman', 'Azərbaycan gənclərinin idman uğurları.', 10, 10);
INSERT INTO comments (post_id, user_id, content, approved, created_by, updated_by)
VALUES (1, 2, 'Çox maraqlı məlumatdır, təşəkkürlər!', TRUE, 2, 2),
       (2, 3, 'Azərbaycan mədəniyyəti həqiqətən zəngindir.', TRUE, 3, 3),
       (3, 4, 'Qarabağda gördüyümüz işlər hər birimiz üçün qürurvericidir.', TRUE, 4, 4),
       (4, 5, 'Novruz bayramı ailələrimizi bir araya gətirir.', TRUE, 5, 5),
       (5, 6, 'İqtisadi inkişafımız sürətlə davam edir!', TRUE, 6, 6),
       (6, 7, 'İncəsənət sərgiləri çox maraqlı keçdi.', TRUE, 7, 7),
       (7, 8, 'Mətbəximiz çox zəngin və dadlıdır!', TRUE, 8, 8),
       (8, 9, 'Nizami Gəncəvi əsərləri ilə dünyaya tanınır.', TRUE, 9, 9),
       (9, 10, 'Təbiətimiz bir çox ölkəyə nümunədir.', TRUE, 10, 10),
       (10, 1, 'İdmançılarımızın uğurları bizi sevindirir!', TRUE, 1, 1);
INSERT INTO likes (user_id, post_id, comment_id, created_at)
VALUES (1, 1, NULL, CURRENT_TIMESTAMP),
       (2, 2, NULL, CURRENT_TIMESTAMP),
       (3, 3, NULL, CURRENT_TIMESTAMP),
       (4, NULL, 1, CURRENT_TIMESTAMP),
       (5, NULL, 2, CURRENT_TIMESTAMP),
       (6, 4, NULL, CURRENT_TIMESTAMP),
       (7, 5, NULL, CURRENT_TIMESTAMP),
       (8, NULL, 3, CURRENT_TIMESTAMP),
       (9, NULL, 4, CURRENT_TIMESTAMP),
       (10, 6, NULL, CURRENT_TIMESTAMP);


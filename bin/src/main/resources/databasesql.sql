/*==============================================================*/
/* DBMS name:      MySQL 8.0                                    */
/* Created on:     2025/2/16 17:08:35                           */
/*==============================================================*/

SET FOREIGN_KEY_CHECKS = 1;

-- 删除表
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS collect_news;
DROP TABLE IF EXISTS collect_posts;
DROP TABLE IF EXISTS comments_news;
DROP TABLE IF EXISTS comments_posts;
DROP TABLE IF EXISTS league;
DROP TABLE IF EXISTS likes_news;
DROP TABLE IF EXISTS likes_posts;
DROP TABLE IF EXISTS news;
DROP TABLE IF EXISTS news_editor;
DROP TABLE IF EXISTS news_league;
DROP TABLE IF EXISTS news_team;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS posts_league;
DROP TABLE IF EXISTS posts_team;
DROP TABLE IF EXISTS report_comments_news;
DROP TABLE IF EXISTS report_comments_posts;
DROP TABLE IF EXISTS report_posts;
DROP TABLE IF EXISTS team;
DROP TABLE IF EXISTS users;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
CREATE TABLE admin (
                       id                   INT AUTO_INCREMENT NOT NULL,
                       name                 VARCHAR(30)        NULL,
                       email                VARCHAR(50)        NULL,
                       password             VARCHAR(128)       NULL,
                       PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: collect_news                                          */
/*==============================================================*/
CREATE TABLE collect_news (
                              id                   INT AUTO_INCREMENT NOT NULL,
                              u_id                 INT                NULL,
                              n_id                 INT                NULL,
                              collect_time         TIMESTAMP          NULL,
                              PRIMARY KEY (id),
                              FOREIGN KEY (n_id) REFERENCES news (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                              FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: collect_posts                                         */
/*==============================================================*/
CREATE TABLE collect_posts (
                               id                   INT AUTO_INCREMENT NOT NULL,
                               u_id                 INT                NULL,
                               p_id                 INT                NULL,
                               collect_time         TIMESTAMP          NULL,
                               PRIMARY KEY (id),
                               FOREIGN KEY (p_id) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                               FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: comments_news                                         */
/*==============================================================*/
CREATE TABLE comments_news (
                               id                   INT AUTO_INCREMENT NOT NULL,
                               u_id                 INT                NULL,
                               n_id                 INT                NULL,
                               content              VARCHAR(2000)      NULL,
                               comment_time         TIMESTAMP          NULL,
                               is_ban               SMALLINT           NULL DEFAULT 0,
                               be_report_count      INT                NULL,
                               PRIMARY KEY (id),
                               FOREIGN KEY (n_id) REFERENCES news (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                               FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: comments_posts                                        */
/*==============================================================*/
CREATE TABLE comments_posts (
                                id                   INT AUTO_INCREMENT NOT NULL,
                                u_id                 INT                NULL,
                                p_id                 INT                NULL,
                                content              VARCHAR(2000)      NULL,
                                comment_time         TIMESTAMP          NULL,
                                is_ban               SMALLINT           NULL DEFAULT 0,
                                ba_report_count      INT                NULL,
                                PRIMARY KEY (id),
                                FOREIGN KEY (p_id) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                                FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: league                                                */
/*==============================================================*/
CREATE TABLE league (
                        id                   INT AUTO_INCREMENT NOT NULL,
                        name                 VARCHAR(50)        NULL,
                        PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: likes_news                                            */
/*==============================================================*/
CREATE TABLE likes_news (
                            id                   INT AUTO_INCREMENT NOT NULL,
                            u_id                 INT                NULL,
                            n_id                 INT                NULL,
                            like_time            TIMESTAMP          NULL,
                            PRIMARY KEY (id),
                            FOREIGN KEY (n_id) REFERENCES news (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                            FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: likes_posts                                           */
/*==============================================================*/
CREATE TABLE likes_posts (
                             id                   INT AUTO_INCREMENT NOT NULL,
                             u_id                 INT                NULL,
                             p_id                 INT                NULL,
                             like_time            TIMESTAMP          NULL,
                             PRIMARY KEY (id),
                             FOREIGN KEY (p_id) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                             FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: news                                                  */
/*==============================================================*/
CREATE TABLE news (
                      id                   INT AUTO_INCREMENT NOT NULL,
                      title                VARCHAR(255)       NULL,
                      content              TEXT               NULL,
                      publish_time         TIMESTAMP          NULL,
                      is_examine           SMALLINT           NULL DEFAULT 0,
                      ne_id                INT                NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (ne_id) REFERENCES news_editor (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: news_editor                                           */
/*==============================================================*/
CREATE TABLE news_editor (
                             id                   INT AUTO_INCREMENT NOT NULL,
                             name                 VARCHAR(30)        NULL,
                             email                VARCHAR(255)       NULL,
                             password             VARCHAR(128)       NULL,
                             PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: news_league                                           */
/*==============================================================*/
CREATE TABLE news_league (
                             n_id                 INT                NULL,
                             l_id                 INT                NULL,
                             id                   INT AUTO_INCREMENT NOT NULL,
                             PRIMARY KEY (id),
                             FOREIGN KEY (l_id) REFERENCES league (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                             FOREIGN KEY (n_id) REFERENCES news (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: news_team                                             */
/*==============================================================*/
CREATE TABLE news_team (
                           n_id                 INT                NULL,
                           t_id                 INT                NULL,
                           id                   INT AUTO_INCREMENT NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (n_id) REFERENCES news (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                           FOREIGN KEY (t_id) REFERENCES team (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: posts                                                 */
/*==============================================================*/
CREATE TABLE posts (
                       id                   INT AUTO_INCREMENT NOT NULL,
                       u_id                 INT                NULL,
                       title                VARCHAR(255)       NULL,
                       content              TEXT               NULL,
                       is_ban               SMALLINT           NULL DEFAULT 0,
                       be_report_count      INT                NULL,
                       likes_count          INT                NULL,
                       collect_count        INT                NULL,
                       is_examine           SMALLINT           NULL DEFAULT 0,
                       PRIMARY KEY (id),
                       FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: posts_league                                          */
/*==============================================================*/
CREATE TABLE posts_league (
                              id                   INT AUTO_INCREMENT NOT NULL,
                              p_id                 INT                NULL,
                              l_id                 INT                NULL,
                              PRIMARY KEY (id),
                              FOREIGN KEY (p_id) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                              FOREIGN KEY (l_id) REFERENCES league (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: posts_team                                            */
/*==============================================================*/
CREATE TABLE posts_team (
                            id                   INT AUTO_INCREMENT NOT NULL,
                            pid                  INT                NULL,
                            t_id                 INT                NULL,
                            PRIMARY KEY (id),
                            FOREIGN KEY (pid) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                            FOREIGN KEY (t_id) REFERENCES team (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: report_comments_news                                  */
/*==============================================================*/
CREATE TABLE report_comments_news (
                                      cn_id                INT                NULL,
                                      u_id                 INT                NULL,
                                      id                   INT AUTO_INCREMENT NOT NULL,
                                      reason               VARCHAR(2000)      NULL,
                                      report_time          TIMESTAMP          NULL,
                                      PRIMARY KEY (id),
                                      FOREIGN KEY (cn_id) REFERENCES comments_news (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                                      FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: report_comments_posts                                 */
/*==============================================================*/
CREATE TABLE report_comments_posts (
                                       cp_id                INT                NULL,
                                       u_id                 INT                NULL,
                                       id                   INT AUTO_INCREMENT NOT NULL,
                                       reason               VARCHAR(2000)      NULL,
                                       report_time          TIMESTAMP          NULL,
                                       PRIMARY KEY (id),
                                       FOREIGN KEY (cp_id) REFERENCES comments_posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                                       FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: report_posts                                          */
/*==============================================================*/
CREATE TABLE report_posts (
                              p_id                 INT                NULL,
                              u_id                 INT                NULL,
                              id                   INT AUTO_INCREMENT NOT NULL,
                              reason               VARCHAR(2000)      NULL,
                              report_time          TIMESTAMP          NULL,
                              PRIMARY KEY (id),
                              FOREIGN KEY (p_id) REFERENCES posts (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
                              FOREIGN KEY (u_id) REFERENCES users (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: team                                                  */
/*==============================================================*/
CREATE TABLE team (
                      id                   INT AUTO_INCREMENT NOT NULL,
                      name                 VARCHAR(50)        NULL,
                      l_id                 INT                NULL,
                      PRIMARY KEY (id),
                      FOREIGN KEY (l_id) REFERENCES league (id) ON UPDATE RESTRICT ON DELETE RESTRICT
);

/*==============================================================*/
/* Table: users                                                */
/*==============================================================*/
CREATE TABLE users (
                       id                   INT AUTO_INCREMENT NOT NULL,
                       name                 VARCHAR(30)        NULL,
                       telephone            VARCHAR(30)        NULL,
                       age                  INT                NULL,
                       email                VARCHAR(30)        NULL,
                       password             VARCHAR(128)       NULL,
                       sex                  SMALLINT           NULL,
                       PRIMARY KEY (id)
);

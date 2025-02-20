/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 12                       */
/* Created on:     2025/2/16 17:08:35                           */
/*==============================================================*/

create database soccer_news_project;

use soccer_news_project;

drop table if exists admin;

drop table if exists collect_news;

drop table if exists collect_posts;

drop table if exists comments_news;

drop table if exists comments_posts;

drop table if exists league;

drop table if exists likes_news;

drop table if exists likes_posts;

drop table if exists news;

drop table if exists news_editor;

drop table if exists news_league;

drop table if exists news_team;

drop table if exists posts;

drop table if exists posts_league;

drop table if exists posts_team;

drop table if exists report_comments_news;

drop table if exists report_comments_posts;

drop table if exists report_posts;

drop table if exists team;

drop table if exists users;


/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
    id       bigint(20)   not null auto_increment,
    name     varchar(30)  null,
    email    varchar(50)  null,
    password varchar(128) null,
    constraint PK_ADMIN primary key (id)
);

/*==============================================================*/
/* Table: collect_news                                          */
/*==============================================================*/
create table collect_news
(
    id           bigint(20) not null auto_increment,
    u_id         bigint(20) null,
    n_id         bigint(20) null,
    collect_time timestamp  null,
    constraint PK_COLLECT_NEWS primary key (id)
);

/*==============================================================*/
/* Table: collect_posts                                         */
/*==============================================================*/
create table collect_posts
(
    id           bigint(20) not null auto_increment,
    u_id         bigint(20) null,
    p_id         bigint(20) null,
    collect_time timestamp  null,
    constraint PK_COLLECT_POSTS primary key (id)
);

/*==============================================================*/
/* Table: comments_news                                         */
/*==============================================================*/
create table comments_news
(
    id              bigint(20)    not null auto_increment,
    u_id            bigint(20)    null,
    n_id            bigint(20)    null,
    content         varchar(2000) null,
    comment_time    timestamp     null,
    is_ban          smallint      null default 0,
    be_report_count integer       null,
    constraint PK_COMMENTS_NEWS primary key (id)
);

/*==============================================================*/
/* Table: comments_posts                                        */
/*==============================================================*/
create table comments_posts
(
    id              bigint(20)    not null auto_increment,
    u_id            bigint(20)    null,
    p_id            bigint(20)    null,
    content         varchar(2000) null,
    comment_time    timestamp     null,
    is_ban          smallint      null default 0,
    ba_report_count integer       null,
    constraint PK_COMMENTS_POSTS primary key (id)
);

/*==============================================================*/
/* Table: league                                                */
/*==============================================================*/
create table league
(
    id   bigint(20)  not null auto_increment,
    name varchar(50) null,
    constraint PK_LEAGUE primary key (id)
);

/*==============================================================*/
/* Table: likes_news                                            */
/*==============================================================*/
create table likes_news
(
    id        bigint(20) not null auto_increment,
    u_id      bigint(20) null,
    n_id      bigint(20) null,
    like_time timestamp  null,
    constraint PK_LIKES_NEWS primary key (id)
);

/*==============================================================*/
/* Table: likes_posts                                           */
/*==============================================================*/
create table likes_posts
(
    id        bigint(20) not null auto_increment,
    u_id      bigint(20) null,
    p_id      bigint(20) null,
    like_time timestamp  null,
    constraint PK_LIKES_POSTS primary key (id)
);

/*==============================================================*/
/* Table: news                                                  */
/*==============================================================*/
create table news
(
    id           bigint(20)   not null auto_increment,
    title        varchar(255) null,
    content      long varchar null,
    publish_time timestamp    null,
    is_examine   smallint     null default 0,
    ne_id        bigint(20)   null,
    constraint PK_NEWS primary key (id)
);

/*==============================================================*/
/* Table: news_editor                                           */
/*==============================================================*/
create table news_editor
(
    id       bigint(20)   not null auto_increment,
    name     varchar(30)  null,
    email    varchar(255) null,
    password varchar(128) null,
    constraint PK_NEWS_EDITOR primary key (id)
);

/*==============================================================*/
/* Table: news_league                                           */
/*==============================================================*/
create table news_league
(
    id   bigint(20) not null auto_increment,
    n_id bigint(20) null,
    l_id bigint(20) null,
    constraint PK_NEWS_LEAGUE primary key (id)
);

/*==============================================================*/
/* Table: news_team                                             */
/*==============================================================*/
create table news_team
(
    id   bigint(20) not null auto_increment,
    n_id bigint(20) null,
    t_id bigint(20) null,
    constraint PK_NEWS_TEAM primary key (id)
);

/*==============================================================*/
/* Table: posts                                                 */
/*==============================================================*/
create table posts
(
    id              bigint(20)   not null auto_increment,
    u_id            bigint(20)   null,
    title           varchar(255) null,
    content         long varchar null,
    is_ban          smallint     null default 0,
    be_report_count integer      null,
    likes_count     integer      null,
    collect_count   integer      null,
    is_examine      smallint     null default 0,
    constraint PK_POSTS primary key (id)
);

/*==============================================================*/
/* Table: posts_league                                          */
/*==============================================================*/
create table posts_league
(
    id   bigint(20) not null auto_increment,
    p_id bigint(20) null,
    l_id bigint(20) null,
    constraint PK_POSTS_LEAGUE primary key (id)
);

/*==============================================================*/
/* Table: posts_team                                            */
/*==============================================================*/
create table posts_team
(
    id   bigint(20) not null auto_increment,
    pid  bigint(20) null,
    t_id bigint(20) null,
    constraint PK_POSTS_TEAM primary key (id)
);

/*==============================================================*/
/* Table: report_comments_news                                  */
/*==============================================================*/
create table report_comments_news
(
    id          bigint(20)    not null auto_increment,
    cn_id       bigint(20)    null,
    u_id        bigint(20)    null,
    reason      varchar(2000) null,
    report_time timestamp     null,
    constraint PK_REPORT_COMMENTS_NEWS primary key (id)
);

/*==============================================================*/
/* Table: report_comments_posts                                 */
/*==============================================================*/
create table report_comments_posts
(
    id          bigint(20)    not null auto_increment,
    cp_id       bigint(20)    null,
    u_id        bigint(20)    null,
    reason      varchar(2000) null,
    report_time timestamp     null,
    constraint PK_REPORT_COMMENTS_POSTS primary key (id)
);

/*==============================================================*/
/* Table: report_posts                                          */
/*==============================================================*/
create table report_posts
(
    id          bigint(20)    not null auto_increment,
    p_id        bigint(20)    null,
    u_id        bigint(20)    null,
    reason      varchar(2000) null,
    report_time timestamp     null,
    constraint PK_REPORT_POSTS primary key (id)
);

/*==============================================================*/
/* Table: team                                                  */
/*==============================================================*/
create table team
(
    id   bigint(20)  not null auto_increment,
    name varchar(50) null,
    l_id bigint(20)  null,
    constraint PK_TEAM primary key (id)
);

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table users
(
    id        bigint(20)   not null auto_increment,
    name      varchar(30)  null,
    telephone varchar(30)  null,
    age       integer      null,
    email     varchar(30)  null,
    password  varchar(128) null,
    sex       smallint     null,
    constraint PK_USER primary key (id)
);

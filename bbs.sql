CREATE TABLE bbs.block
(
    id int(11) PRIMARY KEY NOT NULL,
    from_user_id int(11) NOT NULL,
    target_type int(11) NOT NULL,
    to_target_id int(11) NOT NULL
);
CREATE TABLE bbs.comment
(
    id int(11) PRIMARY KEY NOT NULL,
    create_time datetime NOT NULL,
    is_blocked tinyint(4) NOT NULL,
    is_deleted tinyint(4) NOT NULL,
    target_id int(11) NOT NULL,
    type int(11) NOT NULL,
    user_id int(11) NOT NULL
);
CREATE TABLE bbs.favorite
(
    id int(11) PRIMARY KEY NOT NULL,
    from_user_id int(11) NOT NULL,
    to_post_id int(11) NOT NULL
);
CREATE TABLE bbs.follow
(
    id int(11) PRIMARY KEY NOT NULL,
    from_user_id int(11) NOT NULL,
    to_user_id int(11) NOT NULL
);
CREATE TABLE bbs.permission
(
    id int(11) PRIMARY KEY NOT NULL
);
CREATE TABLE bbs.post
(
    id int(11) PRIMARY KEY NOT NULL,
    content text,
    create_time datetime NOT NULL,
    is_blocked tinyint(4),
    is_deleted tinyint(4),
    is_pin tinyint(4),
    is_remarkable tinyint(4),
    modified_time datetime NOT NULL,
    section_id int(11) NOT NULL,
    title varchar(255) NOT NULL,
    user_id int(11) NOT NULL
);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (1, '其实，随着全球高等教育规模不断扩大，终身教职的竞争在美国早已非常激烈，很多高校的领先院系多年才会授出一个终身教职。辛苦入“轨”的年轻研究者有很大几率在多年努力后被抛出轨道，而很多人甚至连进入考核门槛的资格都没有，只能在“轨”外望洋兴叹，做一个地位、收入、福利保障都低人一等的非终身讲师。据大学教授美国联合会 2016 年发布的报告，这类非终身教师在美国大学中占比已超过 70%', '2018-12-20 16:23:28', 1, 0, 0, 0, '2018-12-20 16:27:24', 5, '狂人日記', 1);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (2, '因此，国内高校稳定的编制曾经也是吸引海外人才归国的一大因素。显然，面对国内的改革，大多数青年学者并没有在观念上做好准备，默认即使国内采用了终身教职制，其考核通过率也不会像美国高校那样残酷，因而武大的高淘汰率才会引起一片哗然', '2018-12-20 16:27:24', 1, 0, 0, 0, '2018-12-20 16:27:24', 5, '鴨的喜劇', 1);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (3, '究其原因，终身教职制度的水土不服根植于中国就业制度和美国的历史差异。在美国，终身制职业极其罕见，大学里的终身教职是美国学界不懈进行劳工斗争的结果，争取的就是学者能够抵抗市场规律的挤压，在终身教职的保障下开展“低效率”的学术生产。而中国在长期实行计划经济体制的历史背景下，和其他行业的“正式工”一样，高校教师一入校就是“终身”。因此，近年来推行的终身教职制度，不仅没有保护青年教师的工作稳定性，反而是打破了这个传统的铁饭碗，让他们直面“非升即走”的险境。', '2018-12-20 16:34:52', 1, 0, 0, 0, '2018-12-20 16:34:52', 5, '端午節', 5);
CREATE TABLE bbs.report
(
    id int(11) PRIMARY KEY NOT NULL,
    from_user_id int(11) NOT NULL,
    target_type int(11) NOT NULL,
    to_target_id int(11) NOT NULL
);
CREATE TABLE bbs.role
(
    id int(11) PRIMARY KEY NOT NULL
);
CREATE TABLE bbs.role_permission
(
    id int(11) PRIMARY KEY NOT NULL
);
CREATE TABLE bbs.section
(
    id int(11) PRIMARY KEY NOT NULL,
    name varchar(50) NOT NULL
);
INSERT INTO bbs.section (id, name) VALUES (1, '情感');
INSERT INTO bbs.section (id, name) VALUES (5, '文化');
INSERT INTO bbs.section (id, name) VALUES (2, '生活');
INSERT INTO bbs.section (id, name) VALUES (3, '科技');
INSERT INTO bbs.section (id, name) VALUES (4, '金融');
CREATE TABLE bbs.thumbs_down
(
    id int(11) PRIMARY KEY NOT NULL,
    from_user_id int(11) NOT NULL,
    target_type int(11) NOT NULL,
    to_target_id int(11) NOT NULL
);
CREATE TABLE bbs.thumbs_up
(
    id int(11) PRIMARY KEY NOT NULL,
    from_user_id int(11) NOT NULL,
    target_type int(11) NOT NULL,
    to_target_id int(11) NOT NULL
);
CREATE TABLE bbs.user
(
    id int(11) PRIMARY KEY NOT NULL,
    avatar varchar(255),
    email varchar(255),
    gender int(11),
    mobile varchar(255),
    name varchar(30) NOT NULL,
    nickname varchar(30) NOT NULL,
    password varchar(255) NOT NULL,
    profession varchar(255),
    work_address varchar(255)
);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (1, 'http://i.mtime.cn/act/transformers/images/temp/b01.jpg', null, null, null, 'jazz', '爵士', '1', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (2, 'http://i.mtime.cn/act/transformers/images/temp/b02.jpg', null, null, null, 'Bumblebee', '大黄蜂', '2', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (3, 'http://i.mtime.cn/act/transformers/images/temp/b03.jpg', null, null, null, 'Ratchet', '救护车', '3', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (4, 'http://i.mtime.cn/act/transformers/images/temp/b04.jpg', null, null, null, 'Ironhide', '铁皮', '4', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (7, 'http://i.mtime.cn/act/transformers/images/temp/b05.jpg', null, null, null, 'Wheeljack', '千斤顶', '5', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (8, 'http://i.mtime.cn/act/transformers/images/temp/b06.jpg', null, null, null, 'Grimlock', '钢锁', '6', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (9, 'http://i.mtime.cn/act/transformers/images/temp/b07.jpg', '', null, null, 'Jetfire', '天火', '7', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (10, 'http://i.mtime.cn/act/transformers/images/temp/b08.jpg', null, null, null, 'Blaster', '录音机', '8', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (11, 'http://i.mtime.cn/act/transformers/images/temp/c5.jpg', null, null, null, 'Starscream', '红蜘蛛', '9', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (12, 'http://i.mtime.cn/act/transformers/images/temp/c10.jpg', null, null, null, 'Thundercracker', '惊天雷', '10', null, null);
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (13, '', null, null, null, 'INeverSay', '周树人', 'mutouren', null, null);
CREATE TABLE bbs.user_role
(
    id int(11) PRIMARY KEY NOT NULL
);
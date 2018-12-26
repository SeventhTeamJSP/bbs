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
    content varchar(255) NOT NULL,
    create_time datetime NOT NULL,
    is_blocked tinyint(4) NOT NULL,
    is_deleted tinyint(4) NOT NULL,
    target_id int(11) NOT NULL,
    type int(11) NOT NULL,
    user_id int(11) NOT NULL
);
INSERT INTO bbs.comment (id, content, create_time, is_blocked, is_deleted, target_id, type, user_id) VALUES (1, '用户id1评论了类型1(POST)id为1', '2018-12-23 08:09:48', 0, 0, 1, 1, 1);
INSERT INTO bbs.comment (id, content, create_time, is_blocked, is_deleted, target_id, type, user_id) VALUES (2, '用户id1评论了类型2(COMMENT)id为1', '2018-12-23 08:09:51', 0, 0, 1, 2, 1);
INSERT INTO bbs.comment (id, content, create_time, is_blocked, is_deleted, target_id, type, user_id) VALUES (3, '用户id2评论了类型1(POST)id为2的', '2018-12-23 08:09:52', 0, 0, 2, 1, 2);
INSERT INTO bbs.comment (id, content, create_time, is_blocked, is_deleted, target_id, type, user_id) VALUES (4, '用户id2评论了类型2(COMMENT)id为2', '2018-12-23 08:09:53', 0, 0, 2, 2, 2);
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
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (1, '塞伯坦上笼罩着一层淡淡的氧基大气层，气候寒冷，适合机器生命和一些碳基生命的生存。有两个卫星环绕着塞伯坦（大小类似于地球的卫星：月球）；每个卫星上都有自己的大气层，它们的密度使得它们具有同塞伯坦一样的重力。汽车人和霸天虎之间数百万年的大战，使得这颗曾经资源丰富，物种繁多的星球呈现资源枯竭现象。这严重地威胁着星球上的居民的生存与发展。更严重的是，这个钢铁行星还发生过“大停机”现象[参看“大停机”]，直到震荡波重新激活了塞伯坦，使得它得以重新运转。', '2018-12-20 16:23:28', 0, 0, 0, 0, '2018-12-20 16:27:24', 1, '塞伯坦星球简介', 1);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (2, '关于塞伯坦的内部构造，历代的学者的研究和描述都很有限。在塞伯坦的地表之下，有很多盘根错节的通道和一套既独立又相互关联的机械系统，其间的众多奥妙之处，仍然是未解之谜。但是有些人，像威震天[参看“霸天虎”]，他相信整个塞伯坦星球就是一座活动的堡垒，是一座可以遨游于茫茫宇宙之间的超级星际战舰。可惜，目前还没有更多的事实能够证明威震天这套狂热的理论。也许，这只是威震天用来蛊惑人心，煽动战乱的一种信仰而已。', '2018-12-20 16:27:24', 0, 0, 0, 0, '2018-12-20 16:27:24', 1, '塞伯坦星球内部', 1);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (3, '铁堡是远古议会的所在地[参看“领导模块”]。它是塞伯坦人的政权中心。大战开始之后，它成了汽车人的基地城市。十角大楼（前塞伯坦军事基地）也自然而然地成为了汽车人的主要军事基地。遵循塞伯坦人的文化习惯，震荡波当权时，在铁堡重建了曾在战火中被摧毁的最高议会阁。震荡波为了掩饰自己的专权统治，曾经安排感知器进入最高议会，但是他又担心科学家怀疑一切的气质会让感知器发现前霸天虎的秘密计划，从而点燃汽车人天生的热爱和平的怜悯之心，因此在随后的某次选举中，安排感知器出局，去专门负责科研工作。随后震荡波又因为影响力和突出的技能，安排一些知名的汽车人进入最高议会，他们是：红色警报，刹车，吊车，滑车和消防车。尽管这些汽车人的确是出色的人才，但是他们没有一个是能胜任这样的一个领导职位。消防车的鲁莽，红色警报的偏执，刹车的漫不经心，滑车的温顺，还有吊车的自负都使得他们成为了震荡波手中的工作高效的傀儡。这样的人事安排足以说明震荡波的野心和虚伪－－尽管在擎天柱重返赛波坦之前，他们从未发觉… 很快，被震荡波蒙蔽的汽车人们，在他们伟大的领袖重返家园之际，在震荡波被赶下权力宝座之时，又重新燃起了斗志，投身到如火如荼的正邪大战之中。', '2018-12-20 16:34:52', 0, 0, 0, 0, '2018-12-20 16:34:52', 1, '塞伯坦星球铁堡', 1);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (4, 'Earth is the third planet from the Sun and the only astronomical object known to harbor life. According to radiometric dating and other sources of evidence, Earth formed over 4.5 billion years ago. Earth''s gravity interacts with other objects in space, especially the Sun and the Moon, Earth''s only natural satellite', '2018-12-20 16:34:52', 0, 0, 1, 0, '2018-12-20 16:34:52', 1, '置顶demo', 1);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (10, '铁堡是远古议会的所在地[参看“领导模块”]。它是塞伯坦人的政权中心。大战开始之后，它成了汽车人的基地城市。十角大楼（前塞伯坦军事基地）也自然而然地成为了汽车人的主要军事基地。遵循塞伯坦人的文化习惯，震荡波当权时，在铁堡重建了曾在战火中被摧毁的最高议会阁。震荡波为了掩饰自己的专权统治，曾经安排感知器进入最高议会，但是他又担心科学家怀疑一切的气质会让感知器发现前霸天虎的秘密计划，从而点燃汽车人天生的热爱和平的怜悯之心，因此在随后的某次选举中，安排感知器出局，去专门负责科研工作。随后震荡波又因为影响力和突出的技能，安排一些知名的汽车人进入最高议会，他们是：红色警报，刹车，吊车，滑车和消防车。尽管这些汽车人的确是出色的人才，但是他们没有一个是能胜任这样的一个领导职位。消防车的鲁莽，红色警报的偏执，刹车的漫不经心，滑车的温顺，还有吊车的自负都使得他们成为了震荡波手中的工作高效的傀儡。这样的人事安排足以说明震荡波的野心和虚伪－－尽管在擎天柱重返赛波坦之前，他们从未发觉… 很快，被震荡波蒙蔽的汽车人们，在他们伟大的领袖重返家园之际，在震荡波被赶下权力宝座之时，又重新燃起了斗志，投身到如火如荼的正邪大战之中。', '2018-12-20 16:34:52', 1, 0, 0, 0, '2018-12-20 16:34:52', 1, 'user2待审核demo', 2);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (6, '有两个主要的理论提出大陆的成长：稳定的成长到现代和在早期的历史中快速的成长。研究显示第二种学说比较可能，早期的地壳是快速成长的，随后跟着长期稳定的大陆地区。在时间尺度上的最后数亿年间，表面不断的重塑自己，大陆持续的形成和分裂。在表面迁徙的大陆，偶尔会结成超大陆。大约在7.5亿年前，已知最早的一个超大陆罗迪尼亚开始分裂，稍后又在6亿至5.4亿年时合并成潘诺西亚大陆，最后是1.8亿年前开始分裂的盘古大陆。 [1] ', '2018-12-20 16:34:52', 0, 1, 0, 0, '2018-12-20 16:34:52', 1, '删除demo', 1);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (7, '铁堡是远古议会的所在地[参看“领导模块”]。它是塞伯坦人的政权中心。大战开始之后，它成了汽车人的基地城市。十角大楼（前塞伯坦军事基地）也自然而然地成为了汽车人的主要军事基地。遵循塞伯坦人的文化习惯，震荡波当权时，在铁堡重建了曾在战火中被摧毁的最高议会阁。震荡波为了掩饰自己的专权统治，曾经安排感知器进入最高议会，但是他又担心科学家怀疑一切的气质会让感知器发现前霸天虎的秘密计划，从而点燃汽车人天生的热爱和平的怜悯之心，因此在随后的某次选举中，安排感知器出局，去专门负责科研工作。随后震荡波又因为影响力和突出的技能，安排一些知名的汽车人进入最高议会，他们是：红色警报，刹车，吊车，滑车和消防车。尽管这些汽车人的确是出色的人才，但是他们没有一个是能胜任这样的一个领导职位。消防车的鲁莽，红色警报的偏执，刹车的漫不经心，滑车的温顺，还有吊车的自负都使得他们成为了震荡波手中的工作高效的傀儡。这样的人事安排足以说明震荡波的野心和虚伪－－尽管在擎天柱重返赛波坦之前，他们从未发觉… 很快，被震荡波蒙蔽的汽车人们，在他们伟大的领袖重返家园之际，在震荡波被赶下权力宝座之时，又重新燃起了斗志，投身到如火如荼的正邪大战之中。', '2018-12-20 16:34:52', 0, 0, 0, 1, '2018-12-20 16:34:52', 1, 'user2精华demo', 2);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (8, '铁堡是远古议会的所在地[参看“领导模块”]。它是塞伯坦人的政权中心。大战开始之后，它成了汽车人的基地城市。十角大楼（前塞伯坦军事基地）也自然而然地成为了汽车人的主要军事基地。遵循塞伯坦人的文化习惯，震荡波当权时，在铁堡重建了曾在战火中被摧毁的最高议会阁。震荡波为了掩饰自己的专权统治，曾经安排感知器进入最高议会，但是他又担心科学家怀疑一切的气质会让感知器发现前霸天虎的秘密计划，从而点燃汽车人天生的热爱和平的怜悯之心，因此在随后的某次选举中，安排感知器出局，去专门负责科研工作。随后震荡波又因为影响力和突出的技能，安排一些知名的汽车人进入最高议会，他们是：红色警报，刹车，吊车，滑车和消防车。尽管这些汽车人的确是出色的人才，但是他们没有一个是能胜任这样的一个领导职位。消防车的鲁莽，红色警报的偏执，刹车的漫不经心，滑车的温顺，还有吊车的自负都使得他们成为了震荡波手中的工作高效的傀儡。这样的人事安排足以说明震荡波的野心和虚伪－－尽管在擎天柱重返赛波坦之前，他们从未发觉… 很快，被震荡波蒙蔽的汽车人们，在他们伟大的领袖重返家园之际，在震荡波被赶下权力宝座之时，又重新燃起了斗志，投身到如火如荼的正邪大战之中。', '2018-12-20 16:34:52', 0, 0, 1, 0, '2018-12-20 16:34:52', 1, 'user2置顶demo', 2);
INSERT INTO bbs.post (id, content, create_time, is_blocked, is_deleted, is_pin, is_remarkable, modified_time, section_id, title, user_id) VALUES (9, '铁堡是远古议会的所在地[参看“领导模块”]。它是塞伯坦人的政权中心。大战开始之后，它成了汽车人的基地城市。十角大楼（前塞伯坦军事基地）也自然而然地成为了汽车人的主要军事基地。遵循塞伯坦人的文化习惯，震荡波当权时，在铁堡重建了曾在战火中被摧毁的最高议会阁。震荡波为了掩饰自己的专权统治，曾经安排感知器进入最高议会，但是他又担心科学家怀疑一切的气质会让感知器发现前霸天虎的秘密计划，从而点燃汽车人天生的热爱和平的怜悯之心，因此在随后的某次选举中，安排感知器出局，去专门负责科研工作。随后震荡波又因为影响力和突出的技能，安排一些知名的汽车人进入最高议会，他们是：红色警报，刹车，吊车，滑车和消防车。尽管这些汽车人的确是出色的人才，但是他们没有一个是能胜任这样的一个领导职位。消防车的鲁莽，红色警报的偏执，刹车的漫不经心，滑车的温顺，还有吊车的自负都使得他们成为了震荡波手中的工作高效的傀儡。这样的人事安排足以说明震荡波的野心和虚伪－－尽管在擎天柱重返赛波坦之前，他们从未发觉… 很快，被震荡波蒙蔽的汽车人们，在他们伟大的领袖重返家园之际，在震荡波被赶下权力宝座之时，又重新燃起了斗志，投身到如火如荼的正邪大战之中。', '2018-12-20 16:34:52', 0, 1, 0, 0, '2018-12-20 16:34:52', 1, 'user2删除demo', 2);
CREATE TABLE bbs.report
(
    id int(11) PRIMARY KEY NOT NULL,
    from_user_id int(11) NOT NULL,
    target_type int(11) NOT NULL,
    to_target_id int(11) NOT NULL
);
CREATE TABLE bbs.role
(
    id int(11) PRIMARY KEY NOT NULL,
    name varchar(50) NOT NULL
);
INSERT INTO bbs.role (id, name) VALUES (1, 'user');
INSERT INTO bbs.role (id, name) VALUES (2, 'vip');
INSERT INTO bbs.role (id, name) VALUES (3, 'admin');
CREATE TABLE bbs.section
(
    id int(11) PRIMARY KEY NOT NULL,
    name varchar(50) NOT NULL
);
INSERT INTO bbs.section (id, name) VALUES (1, '塞伯坦星球');
INSERT INTO bbs.section (id, name) VALUES (2, '二次元');
INSERT INTO bbs.section (id, name) VALUES (3, '星际争霸');
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
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (1, 'http://i.mtime.cn/act/transformers/images/temp/b01.jpg', 'jazz@nediiii.com', 1, '15177445588', 'jazz', '爵士', '1', null, '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (2, 'http://i.mtime.cn/act/transformers/images/temp/b02.jpg', 'bumblebee@nediiii.com', 1, '13210101243', 'Bumblebee', '大黄蜂', '2', 'fighter', '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (3, 'http://i.mtime.cn/act/transformers/images/temp/b03.jpg', 'ratchet@nediiii.com', 2, '17749496658', 'Ratchet', '救护车', '3', 'docker', '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (4, 'http://i.mtime.cn/act/transformers/images/temp/b04.jpg', 'ironhide@nediiii.com', 1, '1518226599', 'Ironhide', '铁皮', '4', '', '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (7, 'http://i.mtime.cn/act/transformers/images/temp/b05.jpg', 'wheeljack@nediiii.com', 2, '1384495252', 'Wheeljack', '千斤顶', '5', null, '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (8, 'http://i.mtime.cn/act/transformers/images/temp/b06.jpg', 'grimlock@nediiii.com', 1, '16674795548', 'Grimlock', '钢锁', '6', null, '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (9, 'http://i.mtime.cn/act/transformers/images/temp/b07.jpg', 'jetfire@nediiii.com', 1, '13232321145', 'Jetfire', '天火', '7', 'jetflight', '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (10, 'http://i.mtime.cn/act/transformers/images/temp/b08.jpg', 'blaster@nediiii.com', 2, '18877483325', 'Blaster', '录音机', '8', 'recorder', '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (11, 'http://i.mtime.cn/act/transformers/images/temp/c5.jpg', 'starscream@nediiii.com', 2, '13825236695', 'Starscream', '红蜘蛛', '9', 'spider', '塞伯坦星球');
INSERT INTO bbs.user (id, avatar, email, gender, mobile, name, nickname, password, profession, work_address) VALUES (12, 'http://i.mtime.cn/act/transformers/images/temp/c10.jpg', 'thundercracker@nediiii.com', 1, '13855475596', 'Thundercracker', '惊天雷', '10', 'cracker', '塞伯坦星球');
CREATE TABLE bbs.user_role
(
    id int(11) PRIMARY KEY NOT NULL,
    role_id int(11) NOT NULL,
    user_id int(11) NOT NULL
);
INSERT INTO bbs.user_role (id, role_id, user_id) VALUES (1, 1, 1);
INSERT INTO bbs.user_role (id, role_id, user_id) VALUES (2, 2, 1);
INSERT INTO bbs.user_role (id, role_id, user_id) VALUES (3, 3, 1);
INSERT INTO bbs.user_role (id, role_id, user_id) VALUES (4, 1, 2);
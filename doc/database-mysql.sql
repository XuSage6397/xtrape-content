
-- ----------------------------
-- Table structure for cms_blog
-- ----------------------------
DROP TABLE IF EXISTS `cms_blog`;
CREATE TABLE `cms_blog`  (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                             `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                             `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                             `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                             `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
                             `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
                             `content` longblob COMMENT '内容',
                             `Top` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '置顶（0否 1是）',
                             `views` int(11) DEFAULT 0 COMMENT '阅读',
                             `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '状态（0暂存 1发布）',
                             `blog_pic` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '首页图片',
                             `blog_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '简介',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '博客信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_blog
-- ----------------------------
INSERT INTO `cms_blog` VALUES (7, 'admin', '2022-01-02 12:25:26', 'admin', '2022-06-15 08:15:40', '阿萨', '1', 0x3C683120636C6173733D22716C2D616C69676E2D63656E746572223EE6B58BE8AF953C2F68313E3C703E312EE58F91E7949FE79A84E59CB0E696B9E998BFE890A8E79A843C2F703E3C703E322EE5958AE6898BE58AA8E998803C2F703E3C703EE998BFE890A8E4BA8BE5AE9EE4B88A3C2F703E, '1', 21, '1', '', '置顶文章');
INSERT INTO `cms_blog` VALUES (10, 'admin', '2022-01-03 02:59:22', '', NULL, '2222', '1', NULL, '0', 0, '0', '', NULL);
INSERT INTO `cms_blog` VALUES (13, 'admin', '2022-01-03 21:37:57', 'admin', '2022-01-13 14:45:08', '强强强强', '1', NULL, '0', 3, '1', '', NULL);
INSERT INTO `cms_blog` VALUES (14, '若依', '2022-01-04 14:31:31', 'admin', '2022-06-13 11:53:18', '若依', '1', 0x3C703E3C62723E3C2F703E, '0', 2, '1', '', NULL);
INSERT INTO `cms_blog` VALUES (16, 'admin', '2022-01-05 09:44:53', 'admin', '2022-06-13 15:14:56', '阿斯顿v奥迪的vvv从vvc从v从 啊高富帅是否公司费格式发给非钢是法国四个非钢', '1', 0x3C68323EE6ADA4E4BA8BE998BFE890A8E79A843C2F68323E3C68333EE5958AE6898BE58AA8E998803C2F68333E3C703E3C656D3EE5958A3C2F656D3E3C656D207374796C653D22636F6C6F723A20726762283233302C20302C2030293B223EE58F91E7949F3C2F656D3E3C656D3EE79A843C2F656D3E3C2F703E3C703E3C733EE5A5A5E8BFAAE58F913C2F733E3C2F703E3C703E3C7370616E207374796C653D226261636B67726F756E642D636F6C6F723A20726762283235352C203235352C2030293B223EE698AFE590A63C2F7370616E3E3C2F703E3C703E3C62723E3C2F703E3C703E3C62723E3C2F703E3C703E3C62723E3C2F703E3C703E3C62723E3C2F703E3C683220636C6173733D22716C2D616C69676E2D63656E746572223E3C7374726F6E673EE5A5A5E8BFAA3C2F7374726F6E673E3C2F68323E3C703E3C753EE5958AE6898BE58AA8E998803C2F753E3C2F703E3C703E3C62723E3C2F703E3C703E3C62723E3C2F703E3C703E3C62723E3C2F703E3C703E3C62723E3C2F703E3C626C6F636B71756F74653E7661722061203D20313B3C2F626C6F636B71756F74653E3C626C6F636B71756F74653E666F7220286C65742069203D20303B206920266C743B31303B20692B2B297B3C2F626C6F636B71756F74653E3C626C6F636B71756F74653E7D3C2F626C6F636B71756F74653E3C70726520636C6173733D22716C2D73796E74617822207370656C6C636865636B3D2266616C7365223E7661722061203D20313B0A666F7220286C65742069203D20303B206920266C743B31303B20692B2B297B0A7D0A3C2F7072653E3C703E3132333C2F703E3C703E3C62723E3C2F703E3C703E3C6120687265663D22687474703A2F2F7777772E62616964752E636F6D222072656C3D226E6F6F70656E6572206E6F726566657272657222207461726765743D225F626C616E6B223EE799BEE5BAA63C2F613E3C2F703E, '0', 79, '1', '', NULL);
INSERT INTO `cms_blog` VALUES (17, 'admin', '2022-01-12 16:06:28', '', NULL, '你好!!!!', '2', 0x3C703EE5928CE982A3E8B7AFE4B88AE79C8BE588B0E4BDA0E7ACACE4B889E696B93C2F703E3C703EE5A4A7E5B888E582853C2F703E3C703EE5958AE6898BE58AA8E998803C2F703E3C703EE5958AE6898BE58AA8E998803C2F703E3C703EE69292E697A63C2F703E, '0', 0, '1', '', NULL);
INSERT INTO `cms_blog` VALUES (18, 'admin', '2022-01-12 16:55:46', 'admin', '2022-02-10 17:00:10', '啊调查啊', '2', 0x3C703EE5958AE5958A3C7374726F6E673EE5958AE588863C2F7374726F6E673E3C2F703E3C703E3C62723E3C2F703E3C6F6C3E3C6C693EE5A5A5E8BFAAE58F913C2F6C693E3C6C693EE5AE89E68A9A3C2F6C693E3C2F6F6C3E3C703E3C7370616E207374796C653D226261636B67726F756E642D636F6C6F723A20726762283235352C203235352C20313032293B223EE5A5A5E8BFAAE58F913C2F7370616E3E3C2F703E3C703E3C7370616E207374796C653D226261636B67726F756E642D636F6C6F723A20726762283235352C203235352C20313032293B223EEFBBBF3C2F7370616E3E3C2F703E, '0', 0, '1', '', NULL);
INSERT INTO `cms_blog` VALUES (19, 'admin', '2022-01-12 17:40:54', 'admin', '2022-06-13 15:14:50', '是VSD v阿萨DVD v大是大非v阿斯蒂芬v地方', '1', 0x3C703E31323334353535E79A84E9A38EE6A0BC3C2F703E, '0', 133, '1', '', NULL);
INSERT INTO `cms_blog` VALUES (22, 'admin', '2022-06-13 09:13:50', 'admin', '2022-06-13 15:14:45', '测试', '1', NULL, '0', 3, '1', '', '萨达VS奥迪发奥迪发奥迪发答复答复答复奥迪奥迪发奥迪发奥迪发答复奥迪发奥迪发奥迪发奥迪发答复答复答复');

-- ----------------------------
-- Table structure for cms_blog_file
-- ----------------------------
DROP TABLE IF EXISTS `cms_blog_file`;
CREATE TABLE `cms_blog_file`  (
                                  `file_id` bigint(20) NOT NULL COMMENT '文件ID',
                                  `blog_id` bigint(20) NOT NULL COMMENT 'blogID',
                                  PRIMARY KEY (`file_id`, `blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'blog文件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `cms_blog_tag`;
CREATE TABLE `cms_blog_tag`  (
                                 `tag_id` bigint(20) NOT NULL COMMENT '标签ID',
                                 `blog_id` bigint(20) NOT NULL COMMENT 'blogID',
                                 PRIMARY KEY (`tag_id`, `blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'blog标签关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_blog_tag
-- ----------------------------
INSERT INTO `cms_blog_tag` VALUES (20, 7);
INSERT INTO `cms_blog_tag` VALUES (20, 22);
INSERT INTO `cms_blog_tag` VALUES (21, 16);
INSERT INTO `cms_blog_tag` VALUES (21, 22);
INSERT INTO `cms_blog_tag` VALUES (22, 22);
INSERT INTO `cms_blog_tag` VALUES (23, 22);
INSERT INTO `cms_blog_tag` VALUES (24, 7);
INSERT INTO `cms_blog_tag` VALUES (24, 22);
INSERT INTO `cms_blog_tag` VALUES (25, 7);
INSERT INTO `cms_blog_tag` VALUES (25, 16);
INSERT INTO `cms_blog_tag` VALUES (25, 22);
INSERT INTO `cms_blog_tag` VALUES (26, 19);
INSERT INTO `cms_blog_tag` VALUES (26, 22);

-- ----------------------------
-- Table structure for cms_blog_type
-- ----------------------------
DROP TABLE IF EXISTS `cms_blog_type`;
CREATE TABLE `cms_blog_type`  (
                                  `type_id` bigint(20) NOT NULL COMMENT '类型ID',
                                  `blog_id` bigint(20) NOT NULL COMMENT 'blogID',
                                  PRIMARY KEY (`type_id`, `blog_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'blog分类关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_blog_type
-- ----------------------------
INSERT INTO `cms_blog_type` VALUES (10, 7);
INSERT INTO `cms_blog_type` VALUES (10, 22);
INSERT INTO `cms_blog_type` VALUES (11, 16);
INSERT INTO `cms_blog_type` VALUES (11, 22);
INSERT INTO `cms_blog_type` VALUES (13, 7);
INSERT INTO `cms_blog_type` VALUES (13, 22);
INSERT INTO `cms_blog_type` VALUES (14, 19);
INSERT INTO `cms_blog_type` VALUES (14, 22);
INSERT INTO `cms_blog_type` VALUES (15, 22);
INSERT INTO `cms_blog_type` VALUES (16, 22);

-- ----------------------------
-- Table structure for cms_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment`  (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                `parent_id` bigint(20) DEFAULT NULL COMMENT '父评论id',
                                `main_id` bigint(20) DEFAULT NULL COMMENT '主评论id(第一级评论)',
                                `like_num` int(11) DEFAULT NULL COMMENT '点赞数量',
                                `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '内容',
                                `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论类型：对人评论，对项目评论，对资源评论',
                                `blog_id` bigint(20) DEFAULT NULL COMMENT '被评论者id，可以是人、项目、资源',
                                `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
                                `user_id` bigint(20) DEFAULT NULL COMMENT '评论者id',
                                `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                                `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                                `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                                `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '评论表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_comment
-- ----------------------------
INSERT INTO `cms_comment` VALUES (1, NULL, NULL, 13, 'v地方', '0', 19, '0', 1, 'admin', '2022-01-28 17:43:08', '', NULL);
INSERT INTO `cms_comment` VALUES (2, 1, 1, NULL, '奥迪发', '1', 19, '0', 1, 'admin', '2022-01-28 17:43:47', '', NULL);
INSERT INTO `cms_comment` VALUES (3, NULL, NULL, 0, '啊吖吖', '0', 16, '0', 1, 'admin', '2022-01-28 18:09:23', '', NULL);

-- ----------------------------
-- Table structure for cms_comment_like
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment_like`;
CREATE TABLE `cms_comment_like`  (
                                     `comment_id` bigint(20) NOT NULL COMMENT '点赞评论ID',
                                     `user_id` bigint(20) NOT NULL COMMENT '用户ID',
                                     `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                                     `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                                     `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                                     PRIMARY KEY (`comment_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '留言点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_message
-- ----------------------------
DROP TABLE IF EXISTS `cms_message`;
CREATE TABLE `cms_message`  (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                `parent_id` bigint(20) DEFAULT NULL COMMENT '父留言id',
                                `main_id` bigint(20) DEFAULT NULL COMMENT '主留言id(第一级留言)',
                                `like_num` int(11) DEFAULT NULL COMMENT '点赞数量',
                                `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '内容',
                                `type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '留言类型：对人评论，对项目评论，对资源评论（0代表留言 1代表回复）',
                                `blog_id` bigint(20) DEFAULT NULL COMMENT '被留言者id，可以是人、项目、资源',
                                `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '删除标志（0代表存在 1代表删除）',
                                `user_id` bigint(20) DEFAULT NULL COMMENT '留言者id',
                                `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                                `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                                `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                                `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 55 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '留言表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_message
-- ----------------------------
INSERT INTO `cms_message` VALUES (1, NULL, NULL, 22, '你好', '0', NULL, '0', 1, 'admin', '2022-01-15 15:24:46', '', NULL);
INSERT INTO `cms_message` VALUES (2, NULL, NULL, 10, 'hello!!  123', '0', NULL, '0', 1, 'admin', '2022-01-15 15:25:26', '', NULL);
INSERT INTO `cms_message` VALUES (3, 1, 1, 2, '我很好!', '1', NULL, '0', NULL, '匿名用户', '2022-01-15 15:25:51', '', NULL);
INSERT INTO `cms_message` VALUES (4, 1, 1, 3, '大家好', '1', NULL, '0', 1, 'admin', '2022-01-15 15:26:23', '', NULL);
INSERT INTO `cms_message` VALUES (5, 3, 1, 3, '好', '1', NULL, '0', 1, 'admin', '2022-01-15 15:26:39', '', NULL);
INSERT INTO `cms_message` VALUES (6, NULL, NULL, 2, '测试', '0', NULL, '0', NULL, '匿名用户', '2022-01-16 18:17:27', '', NULL);
INSERT INTO `cms_message` VALUES (17, 6, 6, NULL, '额', '1', NULL, '0', 1, 'admin', '2022-01-16 20:42:39', '', NULL);
INSERT INTO `cms_message` VALUES (23, 17, 6, NULL, '哈哈', '1', NULL, '0', NULL, '匿名用户', '2022-01-19 01:31:19', '', NULL);
INSERT INTO `cms_message` VALUES (24, 5, 1, NULL, '1', '1', NULL, '0', NULL, '匿名用户', '2022-01-19 01:33:03', '', NULL);
INSERT INTO `cms_message` VALUES (26, 23, 6, NULL, '啊', '1', NULL, '1', 1, 'admin', '2022-01-19 17:17:43', '', NULL);
INSERT INTO `cms_message` VALUES (27, NULL, NULL, 0, '阿斯顿v阿萨v发到付vDVD发v地方vv阿飞阿斯顿v阿萨v阿萨v阿斯顿v阿斯顿v沙发VS发VS的VS调查C ACVASVASVSAVASFVASFVASFVSAVASVASVASFVSVFVSFVSA', '0', NULL, '0', 1, 'admin', '2022-01-19 17:30:29', '', NULL);
INSERT INTO `cms_message` VALUES (28, NULL, NULL, 0, '阿萨的顶顶顶顶顶顶顶顶顶', '0', NULL, '0', 1, 'admin', '2022-01-19 17:30:51', '', NULL);
INSERT INTO `cms_message` VALUES (48, NULL, NULL, 1, 'good!\n', '0', NULL, '0', 2, '若依', '2022-01-20 10:33:14', '', NULL);
INSERT INTO `cms_message` VALUES (49, 1, 1, NULL, '若依', '1', NULL, '0', 2, '若依', '2022-01-20 10:33:32', '', NULL);
INSERT INTO `cms_message` VALUES (50, 2, 2, NULL, '你好\n', '1', NULL, '0', 2, '若依', '2022-01-20 10:33:53', '', NULL);
INSERT INTO `cms_message` VALUES (51, 50, 2, NULL, 'yes', '1', NULL, '0', 1, 'admin', '2022-01-20 10:34:39', '', NULL);
INSERT INTO `cms_message` VALUES (52, 49, 1, NULL, '你好若依\n', '1', NULL, '0', 1, 'admin', '2022-01-20 17:20:24', '', NULL);
INSERT INTO `cms_message` VALUES (53, 26, 6, NULL, '问什么删评论', '1', NULL, '0', 1, 'admin', '2022-01-21 10:13:20', '', NULL);
INSERT INTO `cms_message` VALUES (54, 53, 6, NULL, 'why?', '1', NULL, '0', 2, '若依', '2022-01-21 10:15:47', '', NULL);

-- ----------------------------
-- Table structure for cms_message_like
-- ----------------------------
DROP TABLE IF EXISTS `cms_message_like`;
CREATE TABLE `cms_message_like`  (
                                     `message_id` bigint(20) NOT NULL COMMENT '点赞留言ID',
                                     `user_id` bigint(20) NOT NULL COMMENT '用户ID',
                                     `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                                     `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                                     `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                                     `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                                     PRIMARY KEY (`message_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '留言点赞表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cms_tag
-- ----------------------------
DROP TABLE IF EXISTS `cms_tag`;
CREATE TABLE `cms_tag`  (
                            `tag_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
                            `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                            `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                            `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                            `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                            `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名称',
                            PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_tag
-- ----------------------------
INSERT INTO `cms_tag` VALUES (20, 'admin', '2022-01-03 22:50:05', '', NULL, '啊实打实');
INSERT INTO `cms_tag` VALUES (21, 'admin', '2022-01-03 22:50:23', '', NULL, '打');
INSERT INTO `cms_tag` VALUES (22, 'admin', '2022-01-03 22:50:43', '', NULL, '问问');
INSERT INTO `cms_tag` VALUES (23, 'admin', '2022-01-03 23:30:28', '', NULL, '阿斯弗');
INSERT INTO `cms_tag` VALUES (24, 'admin', '2022-01-03 23:30:32', '', NULL, '阿松大');
INSERT INTO `cms_tag` VALUES (25, 'admin', '2022-01-03 23:30:38', '', NULL, '愤愤愤');
INSERT INTO `cms_tag` VALUES (26, '若依', '2022-01-04 14:48:26', '', NULL, '若依');

-- ----------------------------
-- Table structure for cms_type
-- ----------------------------
DROP TABLE IF EXISTS `cms_type`;
CREATE TABLE `cms_type`  (
                             `type_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
                             `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                             `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                             `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                             `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                             `type_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
                             `type_pic` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '分类图像',
                             PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '分类信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cms_type
-- ----------------------------
INSERT INTO `cms_type` VALUES (10, 'admin', '2022-01-03 23:31:10', '', NULL, '阿萨的', '');
INSERT INTO `cms_type` VALUES (11, 'admin', '2022-01-03 23:31:20', '', NULL, '人然', '');
INSERT INTO `cms_type` VALUES (13, 'admin', '2022-01-03 23:31:29', '', NULL, '啊啊', '');
INSERT INTO `cms_type` VALUES (14, '若依', '2022-01-04 14:31:23', 'admin', '2022-02-10 16:56:00', '若依', '');
INSERT INTO `cms_type` VALUES (15, 'admin', '2022-01-03 21:35:44', '', NULL, '33', '');
INSERT INTO `cms_type` VALUES (16, 'admin', '2022-06-10 16:08:50', 'admin', '2022-06-13 15:14:37', 'java', '');

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
                              `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                              `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '表名称',
                              `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '表描述',
                              `sub_table_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '关联子表的表名',
                              `sub_table_fk_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '子表关联的外键名',
                              `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '实体类名称',
                              `tpl_genus` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
                              `package_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成包路径',
                              `module_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成模块名',
                              `business_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成业务名',
                              `function_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成功能名',
                              `function_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生成功能作者',
                              `gen_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
                              `gen_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
                              `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '其它生成选项',
                              `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '创建者',
                              `create_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
                              `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '' COMMENT '更新者',
                              `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
                              `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
                              PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gen_table
-- ----------------------------
INSERT INTO `gen_table` VALUES (1, 'sys_order', '订单明细表', '', '', 'SysOrder', 'tree', 'com.ruoyi.system', 'order', 'order', '订单明细', 'ruoyi', '0', '/', '{\"treeCode\":\"order_id\",\"treeName\":\"order_name\",\"treeParentCode\":\"order_group\",\"parentMenuId\":\"2000\"}', 'admin', '2021-12-13 15:54:15', '', '2021-12-22 11:20:25', NULL);
INSERT INTO `gen_table` VALUES (4, 'sys_file_info', '文件信息表', NULL, NULL, 'SysFileInfo', 'crud', 'com.ruoyi.cms.fileInfo', 'cms', 'fileInfo', '文件管理', 'ruoyi', '0', '/', '{\"parentMenuId\":2007}', 'admin', '2021-12-29 14:58:04', '', '2021-12-29 14:59:08', NULL);
INSERT INTO `gen_table` VALUES (6, 'cms_blog', '博客信息表', NULL, NULL, 'CmsBlog', 'crud', 'com.ruoyi.cms.blog', 'cms', 'blog', '文章管理', 'ning', '0', '/', '{\"parentMenuId\":2007}', 'admin', '2022-01-01 22:38:51', '', '2022-01-01 22:40:47', NULL);
INSERT INTO `gen_table` VALUES (7, 'cms_tag', '标签信息表', NULL, NULL, 'CmsTag', 'crud', 'com.ruoyi.cms.tag', 'cms', 'tag', '标签管理', 'ning', '0', '/', '{\"parentMenuId\":2007}', 'admin', '2022-01-02 14:48:25', '', '2022-01-02 14:49:54', NULL);
INSERT INTO `gen_table` VALUES (8, 'cms_type', '分类信息表', NULL, NULL, 'CmsType', 'crud', 'com.ruoyi.cms.type', 'cms', 'type', '分类管理', 'ning', '0', '/', '{\"parentMenuId\":2007}', 'admin', '2022-01-02 15:01:07', '', '2022-01-02 15:02:27', NULL);
INSERT INTO `gen_table` VALUES (10, 'cms_message', '留言表', NULL, NULL, 'CmsMessage', 'crud', 'com.ruoyi.cms.message', 'cms', 'message', '留言管理', 'ning', '0', '/', '{\"parentMenuId\":2007}', 'admin', '2022-01-15 13:56:24', '', '2022-01-15 13:56:57', NULL);
INSERT INTO `gen_table` VALUES (11, 'cms_comment', '评论表', NULL, NULL, 'CmsComment', 'crud', 'com.ruoyi.cms.comment', 'cms', 'comment', '评论管理', 'ning', '0', '/', '{\"parentMenuId\":2007}', 'admin', '2022-01-21 09:16:31', '', '2022-01-21 10:13:56', NULL);

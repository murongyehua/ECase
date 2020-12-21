/*
Navicat MySQL Data Transfer

Source Server         : liul
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ecase

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-12-21 16:40:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ecase_project_info
-- ----------------------------
DROP TABLE IF EXISTS `ecase_project_info`;
CREATE TABLE `ecase_project_info` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '项目名称',
  `version` int(11) NOT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注，说明',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` varchar(20) NOT NULL COMMENT '创建时间',
  `last_modify_user` varchar(32) NOT NULL COMMENT '最后修改人',
  `last_modify_time` varchar(20) NOT NULL COMMENT '最后修改时间',
  `history_flag` char(1) NOT NULL COMMENT '历史标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ecase_project_template_field
-- ----------------------------
DROP TABLE IF EXISTS `ecase_project_template_field`;
CREATE TABLE `ecase_project_template_field` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(32) NOT NULL COMMENT '所属项目',
  `field_name` varchar(20) NOT NULL COMMENT '字段名称',
  `field_type` char(1) NOT NULL COMMENT '字段类型，输入、下拉框、单选、多选等',
  `max_length` int(11) DEFAULT NULL COMMENT '最大长度-仅在输入框生效',
  `parameter_type` char(255) NOT NULL COMMENT '参数类型，公共参数-列字段参数',
  `options` varchar(255) DEFAULT NULL COMMENT '可选项',
  `version` int(11) NOT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注，说明',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` varchar(20) NOT NULL COMMENT '创建时间',
  `last_modify_user` varchar(32) NOT NULL COMMENT '最后修改人',
  `last_modify_time` varchar(20) NOT NULL COMMENT '最后修改时间',
  `history_flag` char(1) NOT NULL COMMENT '历史标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ecase_project_version
-- ----------------------------
DROP TABLE IF EXISTS `ecase_project_version`;
CREATE TABLE `ecase_project_version` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `project_id` varchar(32) NOT NULL COMMENT '所属项目',
  `version_num` varchar(32) NOT NULL COMMENT '版本编号',
  `status` char(1) NOT NULL COMMENT '状态',
  `version` int(11) NOT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注，说明',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` varchar(20) NOT NULL COMMENT '创建时间',
  `last_modify_user` varchar(32) NOT NULL COMMENT '最后修改人',
  `last_modify_time` varchar(20) NOT NULL COMMENT '最后修改时间',
  `history_flag` char(1) NOT NULL COMMENT '历史标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ecase_user_info
-- ----------------------------
DROP TABLE IF EXISTS `ecase_user_info`;
CREATE TABLE `ecase_user_info` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `username` varchar(32) NOT NULL COMMENT '登录用户名',
  `password` varchar(32) NOT NULL COMMENT '登录密码-MD5',
  `nickname` varchar(12) NOT NULL COMMENT '昵称',
  `version` int(11) NOT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注，说明',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` varchar(20) NOT NULL COMMENT '创建时间',
  `last_modify_user` varchar(32) NOT NULL COMMENT '最后修改人',
  `last_modify_time` varchar(20) NOT NULL COMMENT '最后修改时间',
  `history_flag` char(1) NOT NULL COMMENT '历史标记',
  `type` char(1) DEFAULT NULL COMMENT '用户类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ecase_user_right
-- ----------------------------
DROP TABLE IF EXISTS `ecase_user_right`;
CREATE TABLE `ecase_user_right` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `user_id` varchar(32) NOT NULL COMMENT '用户',
  `project_id` varchar(32) NOT NULL COMMENT '所属项目',
  `right_type` char(1) NOT NULL COMMENT '权限类型，查看-新增-修改-删除',
  `version` int(11) NOT NULL COMMENT '版本号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注，说明',
  `create_user` varchar(32) NOT NULL COMMENT '创建人',
  `create_time` varchar(20) NOT NULL COMMENT '创建时间',
  `last_modify_user` varchar(32) NOT NULL COMMENT '最后修改人',
  `last_modify_time` varchar(20) NOT NULL COMMENT '最后修改时间',
  `history_flag` char(1) NOT NULL COMMENT '历史标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

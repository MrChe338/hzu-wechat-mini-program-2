-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2023-04-24 23:04:26
-- 服务器版本： 5.7.26
-- PHP 版本： 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `projectservice`
--

-- --------------------------------------------------------

--
-- 表的结构 `project_library`
--

CREATE TABLE `project_library` (
  `id` int(11) NOT NULL,
  `project_name` varchar(100) NOT NULL,
  `college_affiliation` varchar(50) NOT NULL,
  `project_leader` varchar(50) NOT NULL,
  `status` enum('active','deleted') NOT NULL DEFAULT 'active',
  `tags` varchar(100) DEFAULT NULL,
  `background_img` varchar(100) DEFAULT NULL,
  `project_type` enum('老师','学生') NOT NULL,
  `project_intro` text NOT NULL,
  `award_experience` text,
  `recruit_requirements` text,
  `attachment` varchar(100) DEFAULT NULL,
  `likes` int(11) NOT NULL DEFAULT '0',
  `favorites` int(11) NOT NULL DEFAULT '0',
  `userid` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `uuid` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `project_library`
--

INSERT INTO `project_library` (`id`, `project_name`, `college_affiliation`, `project_leader`, `status`, `tags`, `background_img`, `project_type`, `project_intro`, `award_experience`, `recruit_requirements`, `attachment`, `likes`, `favorites`, `userid`, `create_time`, `uuid`) VALUES
(1, '项目一', 'xx学院', '张三', 'active', '技术,开发', 'bg_img1.jpg', '学生', '这是一个非常有趣的项目', '曾经获得过很多奖项', '需要一些前端和后端工程师', 'project1.zip', 10, 1, 1, '2023-04-15 11:23:06', 0xe50fa645db7f11ed993b00ff8612c0ef),
(2, '项目1', '学校1', '张三', 'active', '标签1', 'img1.jpg', '学生', '项目1介绍', NULL, '招募要求1', 'att1.docx', 10, 5, 2, '2023-04-15 02:00:00', 0xbd1a01001d2411ec9b9f6c92bf6cf917),
(3, '项目2', '学校2', '李四', 'active', '标签2', 'img2.jpg', '老师', '项目2介绍', '获奖经历2', NULL, 'att2.docx', 20, 8, 2, '2023-04-16 04:00:00', 0xe7f645c01d2411ecaf966c92bf6cf917),
(4, '项目3', '学校1', '王五', 'active', '标签1,标签2', 'img3.jpg', '学生', '项目3介绍', NULL, '招募要求3', 'att3.docx', 30, 12, 2, '2023-04-17 06:00:00', 0xf199f4401d2411ec96e86c92bf6cf917);

-- --------------------------------------------------------

--
-- 表的结构 `project_likes`
--

CREATE TABLE `project_likes` (
  `id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- 表的结构 `project_members`
--

CREATE TABLE `project_members` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `avatar` varchar(100) DEFAULT NULL,
  `uuid` binary(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `project_members`
--

INSERT INTO `project_members` (`id`, `user_id`, `avatar`, `uuid`) VALUES
(2, 1, 'example.png', 0xe50fa645db7f11ed993b00ff8612c0ef),
(3, 2, 'example.png', 0xe50fa645db7f11ed993b00ff8612c0ef);

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `openid` varchar(100) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `avatar_url` varchar(255) DEFAULT NULL,
  `gender` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`id`, `openid`, `nickname`, `avatar_url`, `gender`) VALUES
(1, '', '微信用户', 'https://thirdwx.qlogo.cn/mmopen/vi_32/POgEwh4mIHO4nibH0KlMECNjjGxQUq24ZEaGT4poC6icRiccVGKSyXwibcPq4BWmiaIGuG1icwxaQX6grC9VemZoJ8rg/132', 0),
(2, 'null', 'bdyx', NULL, 0);

-- --------------------------------------------------------

--
-- 表的结构 `user_favorite_projects`
--

CREATE TABLE `user_favorite_projects` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `user_favorite_projects`
--

INSERT INTO `user_favorite_projects` (`id`, `user_id`, `project_id`, `created_at`) VALUES
(1, 1, 3, '2023-04-15 04:00:00'),
(2, 1, 4, '2023-04-15 04:00:00');

-- --------------------------------------------------------

--
-- 表的结构 `user_favorite_resume`
--

CREATE TABLE `user_favorite_resume` (
  `id` int(11) UNSIGNED NOT NULL,
  `userid` int(11) NOT NULL,
  `resume_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 转存表中的数据 `user_favorite_resume`
--

INSERT INTO `user_favorite_resume` (`id`, `userid`, `resume_id`) VALUES
(1, 1, 2),
(2, 2, 1);

-- --------------------------------------------------------

--
-- 表的结构 `wx_user_resume`
--

CREATE TABLE `wx_user_resume` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL COMMENT '用户id',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `gender` tinyint(1) NOT NULL COMMENT '性别',
  `grade` varchar(20) NOT NULL COMMENT '年级',
  `college` varchar(255) NOT NULL COMMENT '学院',
  `major` varchar(255) NOT NULL COMMENT '专业',
  `tags` varchar(255) NOT NULL COMMENT '个人标签',
  `background_img` varchar(255) DEFAULT NULL COMMENT '背景图',
  `introduction` text COMMENT '个人介绍',
  `skills` text COMMENT '个人特长',
  `hobbies` text COMMENT '兴趣爱好',
  `projects` text COMMENT '项目经历',
  `awards` text COMMENT '获奖情况',
  `others` text COMMENT '其他',
  `project_intention` text COMMENT '项目意向',
  `attachments` varchar(255) DEFAULT NULL COMMENT '附件上传',
  `is_into_talent_pool` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否投入人才库'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='微信小程序用户简历表';

--
-- 转存表中的数据 `wx_user_resume`
--

INSERT INTO `wx_user_resume` (`id`, `userid`, `name`, `gender`, `grade`, `college`, `major`, `tags`, `background_img`, `introduction`, `skills`, `hobbies`, `projects`, `awards`, `others`, `project_intention`, `attachments`, `is_into_talent_pool`) VALUES
(1, 1, '张三', 1, '大三', '计算机学院', '编程', '创新', 'example.png', '我是一个热爱编程的人', '熟悉Java、Python等编程语言', '阅读、游戏、旅行', '参与过校内Hackathon比赛', '获得过校内编程比赛三等奖', '无', '希望加入创新型项目组，提升实战能力', 'example.doc', 1),
(2, 2, '李四', 0, '大二', '艺术学院', '平面设计', '设计, 美术, 摄影', '/img/background.png', '我是一个热爱设计的平面设计师，有着扎实的美术功底，擅长多种设计软件。', '熟练使用 Photoshop、Illustrator、InDesign 等多种设计软件。', '绘画、看电影、旅游。', '1. 设计学校宣传海报\n2. 参与校内设计比赛', '获得校内设计比赛第一名', '我是一个有创造力的人，喜欢挑战和尝试新事物。', '希望加入一个优秀的设计团队，挑战更高难度的设计项目。', '/attachments/resume.pdf', 0);

--
-- 转储表的索引
--

--
-- 表的索引 `project_library`
--
ALTER TABLE `project_library`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_userid` (`userid`),
  ADD KEY `uuid` (`uuid`);

--
-- 表的索引 `project_likes`
--
ALTER TABLE `project_likes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_project_id_like` (`project_id`),
  ADD KEY `fk_user_id_like` (`user_id`);

--
-- 表的索引 `project_members`
--
ALTER TABLE `project_members`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user1_id` (`user_id`),
  ADD KEY `fk_project1_uuid` (`uuid`);

--
-- 表的索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `openid` (`openid`);

--
-- 表的索引 `user_favorite_projects`
--
ALTER TABLE `user_favorite_projects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_user_id` (`user_id`),
  ADD KEY `fk_project_id` (`project_id`);

--
-- 表的索引 `user_favorite_resume`
--
ALTER TABLE `user_favorite_resume`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_userid_resume` (`userid`),
  ADD KEY `fk_resume_id` (`resume_id`);

--
-- 表的索引 `wx_user_resume`
--
ALTER TABLE `wx_user_resume`
  ADD PRIMARY KEY (`id`),
  ADD KEY `userid` (`userid`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `project_library`
--
ALTER TABLE `project_library`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 使用表AUTO_INCREMENT `project_likes`
--
ALTER TABLE `project_likes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `project_members`
--
ALTER TABLE `project_members`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用表AUTO_INCREMENT `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `user_favorite_projects`
--
ALTER TABLE `user_favorite_projects`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `user_favorite_resume`
--
ALTER TABLE `user_favorite_resume`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 使用表AUTO_INCREMENT `wx_user_resume`
--
ALTER TABLE `wx_user_resume`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- 限制导出的表
--

--
-- 限制表 `project_library`
--
ALTER TABLE `project_library`
  ADD CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- 限制表 `project_likes`
--
ALTER TABLE `project_likes`
  ADD CONSTRAINT `fk_project_id_like` FOREIGN KEY (`project_id`) REFERENCES `project_library` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_user_id_like` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- 限制表 `project_members`
--
ALTER TABLE `project_members`
  ADD CONSTRAINT `fk_project1_uuid` FOREIGN KEY (`uuid`) REFERENCES `project_library` (`uuid`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_user1_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- 限制表 `user_favorite_projects`
--
ALTER TABLE `user_favorite_projects`
  ADD CONSTRAINT `fk_project_id` FOREIGN KEY (`project_id`) REFERENCES `project_library` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- 限制表 `user_favorite_resume`
--
ALTER TABLE `user_favorite_resume`
  ADD CONSTRAINT `fk_resume_id` FOREIGN KEY (`resume_id`) REFERENCES `wx_user_resume` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_user_openid_resume` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- 限制表 `wx_user_resume`
--
ALTER TABLE `wx_user_resume`
  ADD CONSTRAINT `wx_user_resume_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

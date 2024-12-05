USE dispatch_task_db;

create table `device_info` (
                               `device_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '设备id',
                               `device_name` varchar(256) COLLATE utf8mb4_general_ci NOT null default '' COMMENT '设备名称',
                               `device_description` varchar(1024) COLLATE utf8mb4_general_ci NOT null default '' COMMENT '设备描述',
                               `device_ip` varchar(256) COLLATE utf8mb4_general_ci NOT null default '' COMMENT '设备ip',
                               `memory` varchar(256) NOT null default '0B' COMMENT '总内存',
                               `disk` varchar(256) NOT null default '0B' COMMENT '总磁盘大小',
                               `online` tinyint NOT NULL DEFAULT '0' COMMENT '是否在线',
                               `type` varchar(128) COLLATE utf8mb4_general_ci not null COMMENT '设备类型（WINDOWS/LINUX/ANDROID/OTHER）',
                               `manager` varchar(128) COLLATE utf8mb4_general_ci not NULL COMMENT '设备管理人姓名',
                               `status` tinyint NOT NULL DEFAULT '0' COMMENT '0新建，1激活，2未激活',
                               `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '0未删除，1删除',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               PRIMARY KEY (`device_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='设备信息表';

create table `heartbeat_info_table`(
                                       `heartbeat_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '心跳信息id',
                                       `device_id` bigint unsigned NOT NULL COMMENT '设备id',
                                       `used_memory` varchar(256) NOT null default '0B' COMMENT '已用内存',
                                       `total_memory` varchar(256) NOT null default '0B' COMMENT '总内存',
                                       `used_disk` varchar(256) NOT NULL default '0B' COMMENT '已用磁盘大小',
                                       `total_disk` varchar(256) NOT null default '0B' COMMENT '总磁盘大小',
                                       `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '0未删除，1删除',
                                       `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                       PRIMARY KEY (`heartbeat_id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='心跳信息表';

create table `task_info`(
                            `task_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '任务id',
                            `params` varchar(2048) COLLATE utf8mb4_general_ci NOT null default '' COMMENT '参数',
                            `task_info` varchar(4096) COLLATE utf8mb4_general_ci NOT null default '' COMMENT '任务信息',
                            `task_creator` varchar(128) COLLATE utf8mb4_general_ci not NULL COMMENT '发起任务执行者',
                            `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '0未删除，1删除',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            PRIMARY KEY (`task_id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='任务信息表';

create table `task_device_relation`(
                                       `relation_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '任务和设备对应关系id',
                                       `task_id` bigint unsigned NOT null COMMENT '任务id',
                                       `device_id` bigint unsigned NOT null COMMENT '设备id',
                                       `heartbeat_id` bigint unsigned NOT null COMMENT '任务执行对应的心跳id',
                                       PRIMARY KEY (`relation_id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='任务设备关系表';


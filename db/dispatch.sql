create table `device_info` (
                               `device_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '设备id',
                               `device_name` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备名称',
                               `device_description` varchar(1024) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备描述',
                               `device_type` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备类型',
                               `online` tinyint NOT NULL DEFAULT '0' COMMENT '是否在线',
                               `type` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备类型（WINDOWS/LINUX/ANDROID）',
                               `manager` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '设备管理人姓名',
                               `status` tinyint NOT NULL DEFAULT '0' COMMENT '0新建，1激活，2未激活',
                               `is_delete` tinyint NOT NULL DEFAULT '0' COMMENT '0未删除，1删除',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               PRIMARY KEY (`device_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='设备信息表';
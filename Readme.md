# Tlias 系统
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.11-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Vue.js](https://img.shields.io/badge/Vue.js-3-4FC08D.svg)](https://vuejs.org/)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)

## 项目概述

Tlias 是一个基于前后端分离架构的企业管理系统，主要用于员工信息管理、部门管理、班级管理、学员管理等企业日常运营功能。项目采用现代化的技术栈，提供完整的用户认证、权限管理、数据报表等功能。

### 主要功能
- **员工管理**：员工信息的增删改查、分页查询
- **部门管理**：部门信息维护
- **班级管理**：班级信息管理
- **学员管理**：学员信息管理
- **系统日志**：操作日志记录和查询
- **用户认证**：JWT Token 认证机制
- **数据报表**：业务数据统计和分析

## 技术栈

### 后端技术栈
- **框架**：Spring Boot 3.5.11
- **Java版本**：Java 17
- **数据库**：MySQL 8.0+
- **ORM框架**：MyBatis 3.0.5
- **分页插件**：PageHelper 1.4.7
- **认证授权**：JWT (jjwt 0.9.1)
- **构建工具**：Maven
- **其他依赖**：
  - Lombok：简化代码
  - Spring Boot Starter AOP：切面编程
  - Apache HttpClient 4.5.14：HTTP客户端

### 前端技术栈
- **框架**：Vue 3.4.33
- **UI组件库**：Element Plus
- **Web服务器**：Nginx (用于静态资源服务和反向代理)

### 架构特点
- **前后端分离**：前端使用Vue + Vite构建，后端使用Spring Boot提供RESTful API
- **模块化设计**：采用Maven多模块架构，代码结构清晰
- **JWT认证**：基于Token的无状态认证机制
- **AOP日志**：使用Spring AOP实现操作日志记录

## 环境要求

### 开发环境
- **Java**：JDK 17 或更高版本
- **Node.js**：16.x 或更高版本（用于前端开发）
- **MySQL**：8.0 或更高版本
- **Maven**：3.6 或更高版本

### 数据库配置
- 数据库名称：`tlias`
- 默认连接配置：
  - URL：`jdbc:mysql://localhost:3306/tlias`
  - 用户名：`username`
  - 密码：`password`


## 项目结构

```
springboot-web-project/
├── frontend/                 # 前端静态资源
│   ├── html/                # Vue构建产物
│   │   ├── assets/          # 静态资源文件
│   │   └── index.html       # 入口文件
│   ├── conf/                # Nginx配置
│   │   └── nginx.conf       # 反向代理配置
│   └── nginx.exe            # Nginx服务器
├── tlias-parent/            # 父项目（依赖管理）
│   └── pom.xml              # 父POM配置
├── tlias-pojo/              # 实体类模块
│   └── src/main/java/com/zlq/pojo/
│       ├── Emp.java         # 员工实体
│       ├── Dept.java        # 部门实体
│       ├── Clazz.java       # 班级实体
│       ├── Student.java     # 学生实体
│       └── Result.java      # 统一返回结果
├── tlias-utils/             # 工具类模块
│   └── src/main/java/com/zlq/utils/
│       ├── JwtUtils.java    # JWT工具类
│       └── CurrentHolder.java # 当前用户信息持有者
└── tlias-web-demo/          # 主应用模块
    ├── src/main/java/com/zlq/
    │   ├── controller/      # 控制器层
    │   │   ├── EmpController.java     # 员工控制器
    │   │   ├── DeptController.java    # 部门控制器
    │   │   ├── LoginController.java   # 登录控制器
    │   │   └── ...
    │   ├── service/         # 服务层
    │   │   ├── impl/        # 服务实现
    │   │   └── *.java       # 服务接口
    │   ├── mapper/          # 数据访问层
    │   ├── config/          # 配置类
    │   ├── filter/          # 过滤器
    │   ├── interceptor/     # 拦截器
    │   ├── aop/             # 切面编程
    │   └── exception/       # 异常处理
    ├── src/main/resources/
    │   ├── application.yml  # 应用配置
    │   └── mapper/          # MyBatis映射文件
    └── pom.xml              # 模块依赖配置
```

### 核心模块说明

#### 后端模块
- **tlias-parent**：父项目，统一管理依赖版本
- **tlias-pojo**：实体类模块，包含所有数据模型
- **tlias-utils**：工具类模块，提供JWT等通用功能
- **tlias-web-demo**：主应用模块，包含业务逻辑和API接口

#### 前端架构
- 基于Vue 3 + Vite构建的单页应用
- 使用Element Plus组件库提供UI界面
- Nginx配置反向代理，将API请求转发到后端服务
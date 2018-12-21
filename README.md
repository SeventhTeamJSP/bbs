# Just another bulletin board system

## project requirement
- jdk 1.8
- mysql 5.7
## how to start
1. create a schemas which named "bbs",
2. create a mysql user which named 'bbs' and identified by 'bbs'
3. make sure the dabasource is reachable in '//localhost:3306/bbs'
4. install the dependencies(IDEA will do it for you)
5. start the APPLICATION in IDEA
## project structure

```
├── Application.java    应用启动类
├── aspect              AOP包
│   └── AopDemo.java
├── config              配置包
│   ├── SpringSecurityConfig.java
│   └── Swagger2Config.java
├── controller          controller包
│   └── UserController.java
├── dto                 dto包
├── entity              实体包
│   ├── BlockEntity.java
│   ├── CommentEntity.java
│   ├── FavoriteEntity.java
│   ├── FollowEntity.java
│   ├── PermissionEntity.java
│   ├── PostEntity.java
│   ├── ReportEntity.java
│   ├── RoleEntity.java
│   ├── RolePermissionEntity.java
│   ├── SectionEntity.java
│   ├── ThumbsDownEntity.java
│   ├── ThumbsUpEntity.java
│   ├── UserEntity.java
│   └── UserRoleEntity.java
├── exception           异常包
├── filter              过滤器包
├── interceptor         拦截器包
├── repository          repository包
│   ├── BbsRepository.java
│   └── UserRepository.java
├── security            spring security相关包
│   └── CustomUserDetailService.java
└── service             服务包
    ├── implement
    │   └── UserServiceImpl.java
    └── UserService.java

```
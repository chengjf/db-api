# 数据库结构设计

---

##1 用户管理
###1.1 用户密码表

|字段名称|字段类型|字段描述|
| --- | --- | --- |
|uid|varchar(100)|用户唯一ID，主键|
|login_name|varchar(100)|用户登录名，not null|
|password|varchar(100)|用户密码，not null|
|email|varchar(100)|用户邮箱|
|full_name|varchar(100)|用户全名|
|created|date|用户创建日期，not null|
|modified|date|用户修改日期，not null|
|lock_expiry|date|用户锁定过期日期|
|wiki_name|varchar(100)|用户wiki显示名|
|attributes|longvarchar|用户属性|

---
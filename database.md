# 数据库结构设计

---

##1 用户管理
###1.1 用户密码表（user）

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
##2 Wiki管理
##2.1 文本表(text)
|字段名称|字段类型|字段描述|
| --- | --- | --- |
|id|varchar(100)|文本唯一ID，主键|
|text|blob|文本内容|
|type|varchar(100)|文本格式，如gizp，utf-8，object等|

##2.2 版本表（revision）

|字段名称|字段类型|字段描述|
| --- | --- | --- |
|id|varchar(100)|版本唯一ID，主键|
|page_id|varchar(100)|指向页面表ID|
|text_id|varchar(100)|指向文本表ID|
|comment|blob|该版本的注释或说明|
|user_id|varchar(100)|该版本的用户ID|
|timestamp|date|该版本创建时间|
|is_deleted|boolean|该版本是否已被删除|
|parent_id|varchar(100)|该版本的的父版本ID|

##2.3 页面表(page)

|字段名称|字段类型|字段描述|
| --- | --- | --- |
|id|varchar(100)|页面唯一ID，主键|
|namespace|varchar(100)|命名空间|
|title|varchar(100)|页面标题|
|counter|int|页面浏览次数|
|latest|varchar(100)|页面最新版本，指向revision表的id|
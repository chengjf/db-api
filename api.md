# 数据库接口管理系统API文档

标签（空格分隔）： Server Client 报文 JSON 数据库接口 管理系统

---

#1. 用户管理
这部分是介绍创建用户，获取用户信息，登陆和登出的相关知识。
#1.1 用户登录

*Request*

>GET /login?username=foo@example.com&password=toosecrettoshow

|name|type|description|
|---|---|---|
|username|string|用户登录名|
|password|string|用户密码|

*Response*

```json
{
  "token": "786-OLaWfBisMY",
  "id": 786
}
```
|name|type|description|
|---|---|---|
|id|int|登陆用户的数字ID|
|token|string|用户验证的Token，该token在调用任何api的时候都需要携带|

#1.2 用户登出

*Request*

> GET /logout?token=1234-VWvO51X69r

|name|type|description|
|---|---|---|
|token|string|用户用来验证的token|

*Response*

该方法无任何返回

#1.3 登陆验证
该API来验证客户端token是否合法或者过期，必须提供一个合法的用户名。

*Request*

> GET /valid_login?username=foo@example.com&token=1234-VWvO51X69r

|name|type|description|
|---|---|---|
|username|string|用户登录名|
|token|string|当前用来验证的token|

*Response*

如果**验证成功**的话，会返回一个新的token，过期时间被刷新。

```json
{
    "token": "786-OLaWfBisMY"
}
```
如果**验证失败**的话，返回一个空的token。

```json
{
    "token": ""
}
```

#1.4 用户注册

*Request*

> POST /user

```json
{
    "email": "user@xyz.com",
    "username": "TestUser",
    "password": "K16ldRr922I1"
}
```


|name|type|description|
|---|---|---|
|email|string|注册用户的邮箱地址|
|username|string|用户的登陆名|
|password|string|用户的密码|

*Response*

```json
{
    "id": 12345
}
```

|name|type|description|
|---|---|---|
|id|int|该注册用户的数字ID|

#1.5 更新用户
更新已有用户的注册信息。

*Request*
> PUT /user/{id_or_username}

|name|type|description|
|---|---|---|
|id_or_username|mixed|该注册用户的数字ID或者用户名|

```json:n
{
    "password": "o0xi8wbnd7sdRF7sdF"
}
```

*Response*

```json
{
    "id": 12345
}
```

|name|type|description|
|---|---|---|
|id|int|该注册用户的数字ID|



#1.6 获取用户

*Request*

> GET /user/{id_or_username}

|name|type|description|
|---|---|---|
|id_or_username|mixed|该注册用户的数字ID或者用户名|

*Response*

```json
{
    "id": 12345,
    "email": "user@xyz.com",
    "username": "TestUser"
}
```


|name|type|description|
|---|---|---|
|id_or_username|mixed|该注册用户的数字ID或者用户名|
|email|string|注册用户的邮箱地址|
|username|string|用户的登陆名|
--------
#2. 用户登录授权

--------
#3. 关联系统信息管理


--------





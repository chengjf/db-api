# ���ݿ�ṹ���

---

##1 �û�����
###1.1 �û������user��

|�ֶ�����|�ֶ�����|�ֶ�����|
| --- | --- | --- |
|uid|varchar(100)|�û�ΨһID������|
|login_name|varchar(100)|�û���¼����not null|
|password|varchar(100)|�û����룬not null|
|email|varchar(100)|�û�����|
|full_name|varchar(100)|�û�ȫ��|
|created|date|�û��������ڣ�not null|
|modified|date|�û��޸����ڣ�not null|
|lock_expiry|date|�û�������������|
|wiki_name|varchar(100)|�û�wiki��ʾ��|
|attributes|longvarchar|�û�����|

---
##2 Wiki����
##2.1 �ı���(text)
|�ֶ�����|�ֶ�����|�ֶ�����|
| --- | --- | --- |
|id|varchar(100)|�ı�ΨһID������|
|text|blob|�ı�����|
|type|varchar(100)|�ı���ʽ����gizp��utf-8��object��|

##2.2 �汾��revision��

|�ֶ�����|�ֶ�����|�ֶ�����|
| --- | --- | --- |
|id|varchar(100)|�汾ΨһID������|
|page_id|varchar(100)|ָ��ҳ���ID|
|text_id|varchar(100)|ָ���ı���ID|
|comment|blob|�ð汾��ע�ͻ�˵��|
|user_id|varchar(100)|�ð汾���û�ID|
|timestamp|date|�ð汾����ʱ��|
|is_deleted|boolean|�ð汾�Ƿ��ѱ�ɾ��|
|parent_id|varchar(100)|�ð汾�ĵĸ��汾ID|

##2.3 ҳ���(page)

|�ֶ�����|�ֶ�����|�ֶ�����|
| --- | --- | --- |
|id|varchar(100)|ҳ��ΨһID������|
|namespace|varchar(100)|�����ռ�|
|title|varchar(100)|ҳ�����|
|counter|int|ҳ���������|
|latest|varchar(100)|ҳ�����°汾��ָ��revision���id|
# Test7

## 实验内容：
### 1.读取手机联系人信息，并用ListView显示。显示界面布局如下所示。（给出读取联系人列表的实现）。

![image](https://user-images.githubusercontent.com/73776665/174310600-7cbe3800-02fa-4941-b3f2-83c7d6411d18.png)



Contact.java
联系人实体类

![image](https://user-images.githubusercontent.com/73776665/174310623-2ce2fb67-1fc0-4536-b4c5-537bd72c932c.png)



phone_item.xml

![image](https://user-images.githubusercontent.com/73776665/174310645-884a00f3-c49e-4b35-8c6f-4c648c7fa0c8.png)



activity_main.xml

![image](https://user-images.githubusercontent.com/73776665/174310653-0eabff33-5046-423b-878d-6ae39d94dfa3.png)


ContactAdapter.java
自定义适配器

![image](https://user-images.githubusercontent.com/73776665/174310674-6cb88b86-abfa-4064-8c73-c5c3dcfdc45e.png)


AndroidManifest.xml
权限声明

![image](https://user-images.githubusercontent.com/73776665/174310685-ce08a806-6b29-4cb1-a183-f7ac6ce40e76.png)


MainActivity.java

![image](https://user-images.githubusercontent.com/73776665/174310703-05bad74a-983e-41d1-ba96-7e199e4fb28c.png)
![image](https://user-images.githubusercontent.com/73776665/174310711-72871bfa-896e-4454-8932-1288fb15f3ae.png)

结果

![image](https://user-images.githubusercontent.com/73776665/174311594-48374bb7-fe72-4ee0-a100-c5fa3f50ca3e.png)



### 2.应用中有一个使用Sqllite保存的数据库db。里面有一个表contacts用于保存联系人的基本信息，这些信息包括姓名，联系电话，性别。要求你创建一个内容提供者，给其他app提供contacts中数据的查询。其他app能够查询contacts表中的所有信息，也可以查询单条联系人的信息。（实验报告给出你自定义的内容提供者的实现）

Contact.java
联系人实体类

![image](https://user-images.githubusercontent.com/73776665/174310823-9fef846d-3e33-416f-bda6-0e43fb7f996b.png)

DatabaseHelper.java
创建数据库db、创建表contacts，初始化contacts数据信息（共四条）

![image](https://user-images.githubusercontent.com/73776665/174310839-1b4e6a08-1b9c-4ecc-ae93-687e1b26f79a.png)
![image](https://user-images.githubusercontent.com/73776665/174311737-bc8e1697-3446-46dc-9794-7ca9d8aa4065.png)

DatabaseHelper.java
自定义内容提供器，继承抽象类ContentProvider，实现方法。
GetType()方法根据传入的内容URI返回相应的MIME类型。
根据实验要求只对query()方法进行具体功能实现，查询所有信息和单条数据信息。

![image](https://user-images.githubusercontent.com/73776665/174310891-4ed9b83d-9f25-40b9-b942-6a5fe5308309.png)

activity_task2.xml

![image](https://user-images.githubusercontent.com/73776665/174310904-551ec217-f5e4-4e26-ad8e-06cd603eff69.png)

AndroidManifest.xml
注册自定义内容提供器

![image](https://user-images.githubusercontent.com/73776665/174310920-e44819e9-8605-4355-8f8f-56690cd4c8f5.png)

Task2Activity.java
对按钮添加监听事件。

![image](https://user-images.githubusercontent.com/73776665/174312189-fd231308-800e-42f2-b4b1-154537a026c9.png)


结果

![image](https://user-images.githubusercontent.com/73776665/174311846-c131f769-5d17-4c99-bb81-861eed72c219.png)
![image](https://user-images.githubusercontent.com/73776665/174312159-f8310d54-aac0-40d4-8926-eb5cdab4c048.png)


![image](https://user-images.githubusercontent.com/73776665/174311860-559bc7c9-5666-4f6b-9b95-cf1abeb7bb5e.png)
![image](https://user-images.githubusercontent.com/73776665/174311878-b50e41cf-c4f7-4b03-b9b2-090049948158.png)
![image](https://user-images.githubusercontent.com/73776665/174311889-91947a32-ca9a-4e11-bb7e-98373f39a1dd.png)
![image](https://user-images.githubusercontent.com/73776665/174311899-78abdc7e-72ce-42af-afc5-027e30a4aeee.png)
![image](https://user-images.githubusercontent.com/73776665/174311995-a41bbfa4-9cb5-4792-a289-34c32e75e504.png)








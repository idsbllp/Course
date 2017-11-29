## 数据库安装教程
装完mysql和navicat才算成功，如果看了还不会或者失败了直接来网校问吧，效率要高百倍
### windows
安装过程注意路径信息！！！！不要求一致但要求你明白你的MySql安装到了哪个目录（本质就是一个软件，跟你们装什么QQ一个道理）
#### MySQL
MySQL进入5.7.7版本以后，压缩包安装需要注意一些地方:

1. 相比较于之前版本，压缩包中没有data文件夹，这里是MySQL的配置数据，在5.7.7版本后，通过初始化命令生成data文件夹，无需手动创建。
2. 相比较于之前版本，需要添加my.ini文件，这个文件写的是MySQL配置，以下是我的MySQL配置文件。(下面是my.ini文件)
		`
		
		[mysqld]
		port=3306
		basedir="E:/Tools/mysql-5.7.19-winx64"#此处是MySQL解压缩后的文件夹路径
		datadir="E:/Tools/mysql-5.7.19-winx64/data\"#此处是要生成配置问价夹data的路径，注意最后\结尾
		max_connections=1000#MySQL的最大连接数
		character-set-server=utf8
		default-storage-engine=INNODB
		lower_case_table_names = 1
		sql_mode=NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES
		#skip-grant-tables
		[client]
		port=3306
		default-character-set=utf8
		[mysql]
		default-character-set=utf8
		`
3. 解压后没有文件夹data，并将my.ini文件放入解压后的文件夹，如图
![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/8.png)

4. 首先运行：“mysqld --initialize-insecure --user=mysql”，这行命令初始化MySQL，执行完这条命令后，MySQL会在根目录自建一个data文件夹，并且建好默认数据库，登录的用户名为root，密码为空。
然后运行：“mysqld -install”，将MySQL注册到Windows服务中。
最后运行：“net start mysql”， 启动MySQL服务。
验证：“mysql -uroot”，以root用户名登陆MySQL，显示如下图：
![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/9.png)

5. 至此，安装完成。

#### navicat
1. 在使用navicat使用前确保你的mysql已经打开
2. 为本地创建一个链接

![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/10.png)
![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/11.png)

3. 双击你创建好的链接

![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/12.png)

4. 这就表明你用navicat链接数据库成功了

### X OS
写在前面，可能有部分同学升级到了最新的系统，这样有可能导致命令行工具失效，可以在安装前先输入以下指令，后点击安装（别去点击获取xcode）

`xcode-select --install`
![安装过程](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/2.png)

#### MySql
1.首先安装Homebrew,[官网这里](https://brew.sh/index_zh-cn.html)。

在Mac终端输入以下指令后自动安装

`/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
`

2.使用brew安装MySql，输入一下指令自动安装

`brew install mysql`

过程如下面几幅图(肯定和你们的略有不同)
![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/1.png)
安装完成，实际安装过程要比这个长很多。

测试安装是否成功，输入以下指令，如果跟图中一致表示成功

`mysql.server start`

![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/3.png)

3.注意:新版的mysql禁止了无密码模式，想要使用mysql必需设置密码(如果通过其他方式安装的mysql安装过程中会给你一个初始化的root密码，务必留意并记录下这个密码，输入下面的指令后第一问需要输入的就是这个密码，这里使用brew安装，因为苹果公司的要求，安装时不能设置初始化密码，所以该指令的第一问不是询问你的初始密码，注意区别)

输入以下指令

`mysql_secure_installation`

下面给出各个问题的回答方式

	`
	Enter password for user root:
	输入系统为你初始话的密码（brew安装的没有这一问）
	
	Would you like to setup VALIDATE PASSWORD plugin?
	是否需要安装该插件 Y
	
	Please enter 0 = LOW, 1 = MEDIUM and 2 = STRONG:
	选择你要设置的密码强度，由于数据库用于学习和本地开发，选择强度最弱并且好记的（12345678就行了）， 输入 0， 仅要求密码长度超过8位
	New password:
	输入新的密码，这里和下面一样，你输入的时候看不到有光标显示，但是实际是输进去的，输完后回车就行
	
	Re-enter new password:
	重复输入新的密码
	
	Do you wish to continue with the password provided?(Press y|Y for Yes, any other key for No)
	输入Y
	
	Remove anonymous users? (Press y|Y for Yes, any other key for No)
	删除匿名用户，输入Y
	
	Disallow root login remotely? (Press y|Y for Yes, any other key for No)
	是否禁止远程登录，输入N
	
	Remove test database and access to it? (Press y|Y for Yes, any other key for No)
	是否删除test数据库，输入N
	
	Reload privilege tables now? (Press y|Y for Yes, any other key for No)
	是否重新加载权限表，输入Y
	`
	
4.进入数据库
输入 `mysql -u root -p`

之后要求你输入密码，就是你才设置的密码

进入后如图：
![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/4.png)

接下来就可以开始你的数据库学习之旅了

5.退出数据库 进入数据库的模式下输入 `quit`

6.关闭数据库服务 退出数据库后输入命令 `mysql.server stop`
#### Navicat
[点这里下载 Navicat](http://xclient.info/s/navicat-premium.html?_=e5fb9f72bde190c3be8b00b14039b1c5)，该网址中亦有详细的安装说明

##### navicat 链接 mysql
1. 点击Connection选择 MySQL， 如图
![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/5.png)
2. 配置信息(如果你没有乱动配置的话)

		`
		1 ConnectionName 链接名称，随意（英文）
		2 HostName/IPAddress 数据库地址 输入 localhost
		3 port 端口 输入 3306
		4 UserName 用户名 输入 root
		5 Password 密码 输入你安装过程中设置的密码
		6 Encoding 字符集 选择 utf-8
		7 Testing 测试链接 配置以上6项好点击
		`

![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/6.png)
![](https://github.com/RedrockTeam/Course/raw/master/content/back/mysql/image/7.png)

3. 如果链接成功，点击右下角的 ok
4. 安装教程至此结束
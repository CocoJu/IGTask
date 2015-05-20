Тестовое задание для компании Improve Group.
Системный требования: jre7/jre8(Oracle) , СУБД mysql, Git.
Для инсталляции и запуска необходимо выполнить следующие действия:
Склонировать репозиторий "git clone https://github.com/CocoJumbo/TestTask.git".
Создать базу с именем price_db в субд MySql (кодировка utf8_general_ci), импортировать данные из файла price_db.sql
находящемся в корне репозитория.
В файле build.gradle в переменной "String tomcat_home =" необходимо указать корневой каталог с сервлет контейнером
Tomcat.
В файле "src\main\resources\META-INF\persistance.xml" в данных строках:
"<property name="hibernate.connection.url" value="jdbc:mysql://localhost:3306/price_db?useUnicode=yes&amp;characterEncoding=UTF-8"/>
<property name="hibernate.connection.username" value="root"/>
<property name="hibernate.connection.password" value=""/>"
указать соответствующие настройки для подключения к БД.
После, находясь в корневой директории репозитория необходимо вызвать команду: "gradlew deploy",
приложение будет доступно по ардресу http://localhost:8080/testtask/ при условии что настройки Tomcat
находятся в состоянии по умолчанию.

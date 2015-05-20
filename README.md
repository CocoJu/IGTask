Тестовое задание для компании Improve Group.</br>
Системный требования: jre7/jre8(Oracle) , СУБД mysql, Git.</br>
Для инсталляции и запуска необходимо выполнить следующие действия:</br>
Склонировать репозиторий "git clone https://github.com/CocoJumbo/TestTask.git".</br>
Создать базу с именем price_db в субд MySql (кодировка utf8_general_ci), импортировать данные из файла price_db.sql</br>
находящемся в корне репозитория.</br>
В файле build.gradle в переменной "String tomcat_home =" необходимо указать корневой каталог с сервлет контейнером Tomcat.</br>
В файле "src\main\resources\META-INF\persistance.xml" в данных строках:</br>
(jdbc:mysql://localhost:3306/price_db?useUnicode=yes&amp;characterEncoding=UTF-8</br>
name="hibernate.connection.username" value="root"</br>
name="hibernate.connection.password" value="")</br>
указать соответствующие настройки для подключения к БД.</br>
После, находясь в корневой директории репозитория необходимо вызвать команду: "gradlew deploy",</br>
приложение будет доступно по ардресу http://localhost:8080/testtask/ при условии что настройки Tomcat</br>
находятся в состоянии по умолчанию.

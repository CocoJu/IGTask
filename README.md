####Тестовое задание для компании "Improve Group"</br>
Требования: jre7/jre8(Oracle) , СУБД mysql, Git.</br>
Используемые технологии: Java, Tomcat, JPA(Hibernate), Servlets, JSTL, MySql, JSP, Gradle
####Развертывание
В файле "src\main\resources\META-INF\persistance.xml" указываются данные для подключения к БД:</br>
(jdbc:mysql://localhost:3306/price_db?useUnicode=yes&amp;characterEncoding=UTF-8</br>
name="hibernate.connection.username" value="root"</br>
name="hibernate.connection.password" value="")</br></br>

"git clone https://github.com/CocoJumbo/TestTask.git".</br>
Создать базу price_db(MySql, utf8_general_ci), импортировать price_db.sql</br>
"gradlew build"</br></br>

Исходный файл: ".\build\libs\IGTask.war"
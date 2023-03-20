# Проект по автоматизации тестирования веб для Альфа-Банк
<a target="_blank" href="https://alfabank.ru/">Веб сайт Альфа-Банк</a>

## :card_file_box: Содержание
- [Технологии и инструменты](#bookmark-технологии-и-инструменты)
- [Запуск из терминала](#bookmark-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#bookmark--jenkins--job-)
- [Allure отчет](#bookmark--отчет-в-allure-report)
- [Уведомление в Telegram](#bookmark--уведомление-в-telegram)
- [Видео прохождения тестов](#bookmark--видео-прохождения-некоторых-тестов)
- [Allure TestOps]()

## :bookmark: Технологии и инструменты
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logos/IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logos/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit5"/></a>
<a href="https://gradle.org/"><img src="images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logos/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a><img src="images/logos/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a><img src="images/logos/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

## :bookmark: Запуск тестов из терминала
Локальный запуск:
```
gradle clean test
```

Удаленный запуск:
```
clean
selenideTest
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-Dremote=${REMOTE}
```
## :bookmark: <img src="images/logos/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a> Jenkins <a target="_blank" href="https://jenkins.autotests.cloud/job/pols-skyeng-ui/"> job </a>

Параметры сборки в Jenkins:

- <code>BROWSER</code> браузер, по умолчанию chrome

- <code>BROWSER_VERSION</code> версия браузера, по умолчанию 100.0

- <code>BROWSER_SIZE</code> размер окна браузера, по умолчанию 1920x1080

- <code>REMOTE</code> адрес удаленного сервера

## :bookmark: <img src="images/logos/Allure.svg" width="25" height="25"  alt="Allure"/></a> Отчет в <a target="_blank" href="https://jenkins.autotests.cloud/job/pols-skyeng-ui/4/allure/">Allure report</a>

### Обзор сборки
<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/overview.jpg">
</p>

### Тесты
<p align="center">
<img title="Allure Suites" src="images/screens/tests.jpg">
</p>

### :bar_chart: Графики
<p align="center">
<img title="Allure Graphs" src="images/screens/graphs.jpg">
</p>

## :bookmark: <img src="images/logos/Telegram.svg" width="25" height="25"  alt="Telegram"/></a> Уведомление в Telegram

<p align="center">
<img title="Allure Overview Dashboard" src="images/screens/telegram.jpg">
</p>

## :bookmark: <img src="images/logos/Selenoid.svg" width="25" height="25" alt="Selenoid"/></a> Видео прохождения некоторых тестов

### Тест #3 По ссылке Пройти тест осуществляется переход к тесту на подбор курса
<p align="center">
  <img title="Selenoid video for test3" src="images/gif/test3.gif">
</p>

### Тест #4 После прохождения теста предлагаются подходящие курсы
<p align="center">
  <img title="Selenoid video for test4" src="images/gif/test4.gif">
</p>

## :bookmark: <img src="images/logos/Allure_TO.svg" width="25" height="25" alt="Allure TestOps"/></a> Добавление интеграции с Allure TestOps

### Allure TestOps overview
<p align="center">
  <img title="Allure TestOps overview" src="images/screens/testops_overview.jpg">
</p>

### Добавление ручных тестов
<p align="center">
  <img title="Allure TestOps manual tests" src="images/screens/manual.jpg">
</p>

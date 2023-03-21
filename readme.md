# <a href="https://alfabank.ru/"><img src="/images/logos/AlfaLogo.png" width="25" height="25"  alt="IDEA"/></a> Проект по автоматизации тестирования веб для Альфа-Банк

<a target="_blank" href="https://alfabank.ru/">Веб сайт Альфа-Банк</a>

## Содержание
- [Стек технологий](#bookmark-cтек-технологий)
- [Запуск из терминала](#запуск-тестов-из-терминала)
- [Сборка в Jenkins](#bookmark--jenkins--job-)
- [Allure отчеты](#bookmark--Allure-отчеты)
- [Уведомление в Telegram](#bookmark--уведомление-в-telegram)
- [Видео прохождения тестов](#bookmark--видеозапись-тестов)
- [Интеграция с Jira](#bookmark--Интеграция-с-Jira)

## :bookmark: Стек технологий
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="/images/logos/IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="/images/logos/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="/images/logos/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="/images/logos/JUnit5.svg" width="50" height="50"  alt="JUnit5"/></a>
<a href="https://gradle.org/"><img src="/images/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="/images/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="/images/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="/images/logos/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="/images/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://qameta.io/"><img src="/images/logos/Allure_TO.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.atlassian.com/software/jira/"><img src="/images/logos/Jira.svg" width="50" height="50"  alt="Jira"/></a>
<a href="https://web.telegram.org/"><img src="/images/logos/Telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

## :bookmark: Запуск тестов из терминала
Локальный запуск:
```
gradle clean test
```
Удаленный запуск:
```
clean selenideTest
```
## :bookmark: <img src="/images/logos/Jenkins.svg" width="25" height="25"  alt="Jenkins"/></a><a target="_blank" href="https://jenkins.autotests.cloud/job/pols-skyeng-ui/"> job </a>

Параметры сборки в Jenkins:

- <code>BROWSER</code> браузер, по умолчанию chrome
- <code>VERSION</code> версия браузера, по умолчанию 100.0
- <code>RESOLUTION</code> размер окна браузера, по умолчанию 800x600
- <code>REMOTE_URL</code> адрес удаленного сервера
- <code>REMOTE_URL_VIDEO</code> адрес удаленного сервера

## :bookmark: <img src="/images/logos/Allure.svg" width="25" height="25"  alt="Allure"/></a><a target="_blank" href="https://jenkins.autotests.cloud/job/pols-skyeng-ui/4/allure/"> отчеты</a>
### Отчет в Allure report
#### Основной отчет
<p align="center">
<img title="Allure Overview Dashboard" src="/images/screens/overview.jpg">
</p>

#### Тесты
<p align="center">
<img title="Allure Suites" src="/images/screens/tests.jpg">
</p>

### Отчет в Allure TestOps
#### Основной отчет
<p align="center">
<img title="Allure Overview Dashboard" src="/images/screens/overview.jpg">
</p>

#### Тесты
<p align="center">
<img title="Allure Suites" src="/images/screens/tests.jpg">
</p>

## :bookmark: <img src="/images/logos/Telegram.svg" width="25" height="25"  alt="Telegram"/> уведомления</a>

<p align="center">
<img title="Allure Overview Dashboard" src="/images/screens/telegram.jpg">
</p>

## :bookmark: <img src="/images/logos/Selenoid.svg" width="25" height="25" alt="Selenoid"/> видеозапись тестов</a>

### Видео запись прохождения тестов
<p align="center">
  <img title="Selenoid video for test4" src="/images/gif/test4.gif">
</p>

## :bookmark: <img src="/images/logos/Allure_TO.svg" width="25" height="25" alt="Jira"/> интеграция</a>

### Allure TestOps overview
<p align="center">
  <img title="Allure TestOps overview" src="/images/screens/testops_overview.jpg">
</p>

### Пример ручных тестов
<p align="center">
  <img title="Allure TestOps manual tests" src="/images/screens/manual.jpg">
</p>

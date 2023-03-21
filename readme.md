# Выбор среды тестирования
## Важно: 
перед запуском тестов положить настроечные файлы (xxx.properties) по пути 
src/test/resources, где xxx - соответствует среде тестирования 
(emulation, real, browserstack или selenoid)

## В gradle передать подходящую команду
### Тесты на эмуляторе
gradle clean emulationTest
### Тесты на реальном устройстве
gradle clean realTest
### Тесты по средствам BrowserStack
gradle clean browserstackTest
### Тесты на удаленном стенде через Selenide
gradle clean selenoidTest
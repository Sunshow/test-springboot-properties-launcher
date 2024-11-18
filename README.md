## package app

```shell
./gradlew clean build
```

## package plugin

```shell
./gradlew packageDependencies
```

## run

```shell
java -cp app-1.0-SNAPSHOT.jar -Dloader.path=/Users/sunshow/GIT/sunshow/test-springboot-properties-launcher/plugin/build/distributions  org.springframework.boot.loader.launch.PropertiesLauncher
```

## test

```shell
➜  test-springboot-properties-launcher git:(main) ✗ curl http://localhost:8080/app/test
Hello, this is a app.%
➜  test-springboot-properties-launcher git:(main) ✗ curl http://localhost:8080/plugin/test
Hello, this is a plugin.%
```
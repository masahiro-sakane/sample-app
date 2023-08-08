# ベースイメージはeclipse-temurin(旧OpenJDK)のJava17を使用
FROM docker.io/eclipse-temurin:17-jre-alpine
# 作業ディレクトリを/(root)にする
RUN cd /
# Mavenのビルド成果物(hello-app.jar)をコンテナイメージにCOPY
COPY target/hello-app.jar ./hello-app.jar
# Mavenのビルド成果物(libs以下を)をコンテナイメージにCOPY
COPY target/libs/* .
# ExecutableJarをjavaコマンドで起動
java -jar hello-app.jar

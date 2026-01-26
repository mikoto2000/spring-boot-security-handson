# Spring Boot Security ワークショップ

## Spring Initializr

[これ](https://start.spring.io/#!type=maven-project&language=java&platformVersion=4.0.2&packaging=jar&configurationFileFormat=yaml&jvmVersion=25&groupId=dev.mikoto2000&artifactId=security&name=security&description=Demo%20project%20for%20Spring%20Security&packageName=dev.mikoto2000.security&dependencies=devtools,lombok,web,postgresql,mybatis,security,thymeleaf)

## インデックスページの作成

TODO:


## デフォルトの挙動

Spring Security の設定をしていない場合、起動時に以下のようにログインパスワードが表示されます。

```
2026-01-26T09:53:39.057Z  WARN 6610 --- [security] [  restartedMain] .s.a.UserDetailsServiceAutoConfiguration : 

Using generated security password: 5c89d5fc-d4ff-49b9-8bc0-62cb35f4f13d

This generated password is for development use only. Your security configuration must be updated before running your application in production.

```

デフォルトユーザーは `user` なので、このユーザー名・パスワードでログインできます。

`http://localhost:8080` を開き、ユーザー名: `user`, パスワード: `<起動時に表示されたパスワード>` でログインし、インデックスページが表示されれば OK です。



## ログインユーザー取得ロジックのカスタマイズ

TODO:


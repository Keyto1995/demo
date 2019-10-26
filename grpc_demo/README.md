# grpc-demo

> GRPC是一个高性能、通用的开源RPC框架，基于HTTP/2协议标准和Protobuf序列化协议开发，支持众多的开发语言。

在GRPC框架中，客户端可以像调用本地对象一样直接调用位于不同机器的服务端方法，如此我们就可以非常方便的创建一些分布式的应用服务。

`gRPC` 使用 `protocol buffers` 作为接口描述语言（IDL）以及底层的信息交换格式，一般情况下推荐使用 `proto3` 因为其能够支持更多的语言，并减少一些兼容性的问题。

## 1.添加依赖
```xml
<!-- https://mvnrepository.com/artifact/io.grpc/grpc-all -->
<dependency>
    <groupId>io.grpc</groupId>
    <artifactId>grpc-all</artifactId>
    <version>1.24.0</version>
</dependency>
```

## 2.添加插件
```xml
<build>
    <extensions>
        <extension>
            <groupId>kr.motd.maven</groupId>
            <artifactId>os-maven-plugin</artifactId>
            <version>1.6.2</version>
        </extension>
    </extensions>
    <plugins>
        <plugin>
            <groupId>org.xolstice.maven.plugins</groupId>
            <artifactId>protobuf-maven-plugin</artifactId>
            <version>0.6.1</version>
            <configuration>
                <protocArtifact>com.google.protobuf:protoc:3.10.0:exe:${os.detected.classifier}</protocArtifact>
                <pluginId>grpc-java</pluginId>
                <pluginArtifact>io.grpc:protoc-gen-grpc-java:1.24.0:exe:${os.detected.classifier}</pluginArtifact>
            </configuration>
            <executions>
                <execution>
                    <id>protobuf-generate</id>
                    <phase>process-resources</phase>
                    <goals>
                        <goal>compile</goal>
                        <goal>compile-custom</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

## 3.编写proto
在 `src/main/proto` 下 `*.proto`
```proto
syntax = "proto3";

option java_multiple_files = true;
option java_package = "top.keyto.demo.grpc.helloworld";
option java_outer_classname = "HelloWorldProto";

package helloworld;

// The greeting service definition.
service Greeter {
    // Sends a greeting
    rpc SayHello (HelloRequest) returns (HelloReply) {
    }
}

// The request message containing the user's name.
message HelloRequest {
    string name = 1;
}

// The response message containing the greetings
message HelloReply {
    string message = 1;
}
```

## 4.生成grpc和proto的Java代码
```sh
mvn -Dfile.encoding=UTF-8 compile
```

## 5.编写server
[HelloWorldServer](./src/main/java/top/keyto/demo/grpc/HelloWorldServer.java)

## 6.编写client
[HelloWorldClient](./src/main/java/top/keyto/demo/grpc/HelloWorldClient.java)
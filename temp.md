# 配置片段

## 阿里镜像

```xml
<mirror>
  <!--This sends everything else to /public -->
  <id>nexus</id>
  <mirrorOf>*</mirrorOf>
  <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
</mirror>
<mirror>
  <id>nexus-public-snapshots</id>
  <mirrorOf>public-snapshots</mirrorOf>
  <url>http://maven.aliyun.com/nexus/content/repositories/snapshots/</url>
</mirror>
```

## 命令

```bash
mvn clean deploy 部署到远程服务器上
mvn clean compile 编译
mvn clean package 打包
mvn clean install 上传到本地仓库
```

```xml
<plugin>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok-maven-plugin</artifactId>
    <version>1.16.8.0</version>
    <executions>
        <execution>
            <phase>generate-sources</phase>
            <goals>
                <goal>delombok</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
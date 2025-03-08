<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>${groupId}</groupId>
    <artifactId>${artifactId}</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>${name}</name>
    <description>${description}</description>
    <url/>
    <licenses>
        <license/>
    </licenses>
    <developers>
        <developer/>
    </developers>
    <scm>
        <connection/>
        <developerConnection/>
        <tag/>
        <url/>
    </scm>
    <properties>
        <java.version>17</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
        <!-- <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>2.0.34</version>
        </dependency> -->
        <!--  FastJson2中FastJsonHttpMessageConverter找不到类问题 by https://zhengkai.blog.csdn.net/-->
        <!-- https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2 -->
        <!--        <dependency>-->
        <!--            <groupId>com.alibaba.fastjson2</groupId>-->
        <!--            <artifactId>fastjson2</artifactId>-->
        <!--            <version>2.0.53</version>-->
        <!--        </dependency>-->
        <!--        <dependency>-->
        <!--            <groupId>com.alibaba.fastjson2</groupId>-->
        <!--            <artifactId>fastjson2-extension</artifactId>-->
        <!--            <version>2.0.53</version>-->
        <!--        </dependency>-->
        <!--        &lt;!&ndash; https://mvnrepository.com/artifact/com.alibaba.fastjson2/fastjson2-extension-spring6 &ndash;&gt;-->
        <!--        <dependency>-->
        <!--            <groupId>com.alibaba.fastjson2</groupId>-->
        <!--            <artifactId>fastjson2-extension-spring6</artifactId>-->
        <!--            <version>2.0.53</version>-->
        <!--        </dependency>-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.83</version>
        </dependency>
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <version>3.12.0</version> <!-- 请根据需要选择具体版本 -->
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.0.4</version> <!-- 请根据需要选择具体版本 -->
        </dependency>


        <!-- 添加 MyBatis-Plus 依赖 -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.5.10.1</version>
            <exclusions>
                <exclusion>
                    <groupId>org.mybatis</groupId>
                    <artifactId>mybatis-spring</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>3.0.4</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.5.10.1</version>
        </dependency>
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-jsqlparser</artifactId>
            <version>3.5.10.1</version>
        </dependency>
        <dependency>
            <groupId>org.freemarker</groupId>
            <artifactId>freemarker</artifactId>
        </dependency>
        <!-- 添加 MySQL 驱动依赖 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.33</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!--            <plugin>-->
            <!--                <groupId>org.apache.maven.plugins</groupId>-->
            <!--                <artifactId>maven-compiler-plugin</artifactId>-->
            <!--                <configuration>-->
            <!--                    <annotationProcessorPaths>-->
            <!--                        <path>-->
            <!--                            <groupId>org.projectlombok</groupId>-->
            <!--                            <artifactId>lombok</artifactId>-->
            <!--                        </path>-->
            <!--                    </annotationProcessorPaths>-->
            <!--                </configuration>-->
            <!--            </plugin>-->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

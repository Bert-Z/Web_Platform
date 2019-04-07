# Calculator v2.0

### 前言
>- 这个项目是用spring boot-maven搭建的calculator的后端，因为没有写前端，所以运行的话暂时只能用postman来测试。
>- 关于传参方法，考虑到这次作业没有前端，就只写了一个GET方法的。

### 使用方法 
```bash
    //转到calculator目录
    cd calculator
    
    //将项目大包围可执行的jar包
    mvn clean package
    
    //运行
    cd target
    java -jar bert-1.0-SNAPSHOT.jar
```

### Postman文件
> postman文件可以直接导入到postman中进行使用，注意修改端口为本地tomcat端口


### 参数格式
> 只有一个参数 "input"，类型为String，在其中输入一个表达式，例如
           
    3*8;
    3!;
    
> 然后会返回一个json，result属性的值对应的就是答案。

>注意：
>- 输入的值中最后都要以分号结尾
>- 输入的字符中不要带有空格，因为GET方法的加号为特殊字符，会视为新增加一个参数，并且原来加号的位置会作为空格处理，所以我在函数里将得到的字符串中的空格转为了加号来处理，虽然很笨，但是因为不是post方法来做的，所以暂时只能这么处理。
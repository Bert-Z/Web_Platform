# Homework3 Microservice Example



## Part 1 结构

> client在启动应用之后，要使用应用，需要先通过spring-security 的验证，验证通过了才能进行后续操作。

> gateway和calculator分别在两个不同的container中，以netflix-zuul为反向代理，通过gateway对calculator的事件进行分发，从而实现为服务的体系。



## Part 2  使用

```bash
docker pull bertzhang/gateway-calculator-microservice

docker pull bertzhang/calculator-microservice

docker run -d --name=gateway -p 8080:8080 bertzhang/gateway-calculator-microservice

docker run -d --name=calculator -p 8090:8090 bertzhang/calculator-microservice
```

然后在网页上输入<http://localhost:8080/login>即可进行之后操作


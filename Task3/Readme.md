# Task3
---

## Dockerhub Repo
> https://hub.docker.com/r/bertzhang/calculator

## Run application in local container
```bask
docker pull bertzhang/calculator
docker run -d -p 9000:9000 bertzhang/calculator
```
(之所以是9000而不是8080是因为我在spring项目里写了代理的端口)
然后check一下container

```bash
docker container ls
```
能看到 bertzhang/calculator 的信息。
然后访问
> localhost:9000

就能看到web的信息了



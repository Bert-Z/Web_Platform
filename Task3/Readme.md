# Task3
---

## Dockerhub Repo
> https://hub.docker.com/r/bertzhang/calculator

## Run application in local container
```bask
docker pull bertzhang/calculator
docker run -d -p 8080:8080 bertzhang/calculator
```
因为我在springboot里面写了代理的端口，所以实际端口应该是9000。
然后check一下container

```bash
docker container ls
```
能看到 bertzhang/calculator 的信息。
然后访问
> localhost:9000

就能看到web的信息了



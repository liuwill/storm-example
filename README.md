# storm-example

安装环境：
```shell
# 1 下载压缩包
./script/download_resource.sh

# 2 安装docker镜像
./install_storm.sh

# 3 进入镜像环境
docker exec -it storm-example /bin/bash

# 4 安装java和python环境
./script/install_env.sh

# 5 安装storm环境
./script/install_storm.sh

# 6 运行storm任务
./script/run_task.sh

```

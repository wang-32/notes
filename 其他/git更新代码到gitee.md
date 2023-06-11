# git更新代码到gitee

1. git status 查看当前有变更的代码文件
2. git add ./(git add .)本地所有修改了的文件添加到暂存区
3. git [commit](https://so.csdn.net/so/search?q=commit&spm=1001.2101.3001.7020) -m “xxxxx” 引号里面是你的介绍，就是你的这次的提交是什么内容，便于你以后查看，这个是将索引的当前内容与描述更改的用户和日志消息一起存储在新的提交中。
4. git push origin master 将代码推至远程就可以了。这里master可以是其他分支名字。


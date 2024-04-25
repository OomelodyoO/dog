### cluster常用命令
```shell
# 三台机器组成集群，其它三台机器为从节点
redis-cli --cluster create 192.168.102.254:6379 192.168.102.254:6380 192.168.102.254:6381 192.168.102.254:6382 192.168.102.254:6383 192.168.102.254:6384 --cluster-replicas 1
#-c 用于启动集群模式
redis-cli -h 192.168.102.254:6379 -c
# 打印集群的信息
CLUSTER INFO 
# 列出集群当前已知的所有节点（node），以及这些节点的相关信息。
CLUSTER NODES 
```
### sentinel常用命令
等了好久才切换成功
```shell
#连接当前sentinel(同连接redis类似)
redis-cli -h 127.0.0.1 -p 26379

#sentinel的基本状态信息 
info

#显示被监控的所有master以及它们的状态
sentinel masters

#显示指定master的信息和状态
sentinel master [sentinel中自定义的master名]

#显示指定master的所有slave以及它们的状态
sentinel slaves [sentinel中自定义的master名]

#返回指定master的ip和端口，如果正在进行failover或者failover已经完成，将会显示被提升为master的slave的ip和端口
sentinel get-master-addr-by-name [sentinel中自定义的master名]

#重置名字匹配该正则表达式的所有的master的状态信息，清楚其之前的状态信息，以及slaves信息
sentinel reset [sentinel中自定义的master名]

#列出指定名称下其他sentinel信息
sentinel sentinels [sentinel中自定义的master名]

#当主服务器失效时，在不询问其他Sentinel意见的情况下,强制开始一次自动故障迁移，但是它会给其他sentinel发送一个最新的配置，其他sentinel会根据这个配置进行更新
sentinel failover [sentinel中自定义的master名]
```
# Redis对象

## Redis对象

### Object是什么？

Redis是key-value存储，key和value在Redis中都被抽象为对象，key只能是String对象，而Value支持丰富的对象种类，包括String、List、Set、Hash、Sorted Set、Stream等。

### Object在内存中是什么样子

redisObject定义如下：

```c
// from Redis 5.0.5
#define LRU_BITS 24

typedef struct redisobject{
	unsigned type :4;
	unsigned encoding:4;
	unsigned lru:LRU_BITS;/* LRU time or
						   *LFu data */
	int refcount;
	void *ptr;
}robj;
```

type：是哪种Redis对象

encoding：表示用哪种底层编码，用OBJECT ENCODING[key]可以看到对应的编码方式

lru:记录对象访问信息，用于内存淘汰

refcount:引用计数，用来描述有多少个指针，指向该对象

ptr:内容指针，指向实际内容

### 对象与数据结构

实际操作的主要有7个Redis对象，他们底层依赖一些数据结构，包括字符串、跳表、哈希表、压缩列表、双端链表等，不同对象可能有依赖相同数据结构，4.0加了module，5.0加了stream，不过module对象一班我们不做模块开发其实不会遇到。

## String

### String是什么

String是字符串，它是Redis中最基本的数据对象，最大为512MB。

### 适用场景

一般可以用来存字节数据、文本数据、序列化后的对象数据等

### 常用操作

常用操作聚焦于创建、查询、更新和删除。

创建，即产生一个字符串对象数据，可以用SET、SETNX。

查询操作可以用GET，如果想一次获取多个，可以用MGET。

更新的话，其实也是用SET来更新的。

删除就是针对String对象本身的销毁，用DEL命令。

![image-20230619131816977](https://giteetuchuang.oss-cn-beijing.aliyuncs.com/img_for_typora/image-20230619131816977.png)


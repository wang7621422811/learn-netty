# 学习Netty代码笔记记录
```
learn-netty
+---c1  阻塞IO代码示例

```

## 1. 为什么要替换掉阻塞IO
因为阻塞IO每次只能处理一个客户端连接，如果要管理多个客户端连接则需要为每个新的客户端Socket建立一个新的线程，
1. 这种方案可能有大量的线程是睡眠的状态， 只是等待读取或者写入，产生一种资源浪费
2. 需要为每个线程都分配调用堆栈内存，其默认值是64kb到1MB之间，这取决于操作系统
3. 线程上下文切换所带来的的麻烦，浪费cpu资源

为了解决阻塞IO带来的问题，在后面版本中加入了Java NIO解决高并发问题
## 2. NIO
NIO是(Non-blocking I/O)的简称，是非阻塞IO，从JDK1.4版本的java.nio包中开始支持，让提供了一套非阻塞的API让开发者可以开发更高性能的网络应用
后面要详细补充
## 3. Netty
# Redis入门

## Redis是什么

Redis是一个KV存储

Redis是一个内存存储

## 解决什么问题

常用于缓存、消息中转、数据流引擎

## 支持什么数据结构

提供了strings, hashes lists, sets, sorted sets with range queries, bitmaps, hyperloglogs, geospatial indexes,and streams一系列数据结构。

## 有什么特性

Redis has built-in replication, Lua scripting,LRU eviction, transactions, and different levels of on-diskpersistence, and provides high availability via Redis Sentinel and automatic partitioning with Redis Cluster.

## 版本选择

推荐5.0.5，6.0之前比较新的版本，可以避免多线程额外的复杂度，大厂很多部门都是用的5.0版本。

## Base理论

Base理论是CAP中的一致性的妥协，Base不追求强一致性，而是允许数据在一段时间内是不一致的，但最终达到一致状态，从而获得更高的可用性和性能。
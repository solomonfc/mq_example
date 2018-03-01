启动redis服务器:redis-server ./redis.conf

	redis_7000.conf 是master的配置   
	redis_8000.conf 是slave的配置


启动redis哨兵:redis-sentinel ./redis_sentinel.conf
	redis_sentinel.conf 是sentinel的配置
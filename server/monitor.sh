redis_host="127.0.0.1"
redis_port="7000"
redis_password="h@HZI7SyC6v23QkL2&BV6^dfe7OUufW3"

used_memory=`redis-cli -h ${redis_host} -p ${redis_port} -a ${redis_password} INFO MEMORY | grep "used_memory_human:" | awk -F ':' '{print $2}'`
echo ${redis_host}:${redis_port} memory used:${used_memory}

clist_length=`redis-cli -h ${redis_host} -p ${redis_port} -a ${redis_password} LLEN clist`
echo ${redis_host}:${redis_port} clist length:${clist_length}
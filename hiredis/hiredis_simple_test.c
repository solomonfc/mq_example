#include <stdio.h>
#include <hiredis/hiredis.h>

int main()
{

	redisContext *c = redisConnect("127.0.0.1", 7000);
	if (c == NULL || c->err) {
		if (c) {
			printf("Error: %s\n", c->errstr);
			// handle error
		} else {
			printf("Can't allocate redis context\n");
		}
	}

	redisReply *reply;

	reply = redisCommand(c, "AUTH h@HZI7SyC6v23QkL2&BV6^dfe7OUufW3");
	freeReplyObject(reply);

	reply = redisCommand(c, "SET %s %s", "foo", "bar");
	freeReplyObject(reply);

	reply = redisCommand(c, "GET %s", "foo");
	printf("%s\n", reply->str);
	freeReplyObject(reply);

	reply = redisCommand(c, "LPUSH %s %s", "clist", "spring");
	freeReplyObject(reply);

	reply = redisCommand(c, "LPUSH %s %s", "clist", "hibernate");
	freeReplyObject(reply);

	reply = redisCommand(c, "LPUSH %s %s", "clist", "struts");
	freeReplyObject(reply);

	reply = redisCommand(c, "RPOP %s", "clist");
	printf("%s\n", reply->str);
	freeReplyObject(reply);

	redisFree(c);

	return 0;
}

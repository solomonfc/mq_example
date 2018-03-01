#include <stdio.h>
#include <sys/timeb.h>
#include <hiredis/hiredis.h>

long long getSystemTime() {
    struct timeb t;
    ftime(&t);
    return 1000 * t.time + t.millitm;
}

int main(int argc,char *argv[]){
	


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
	
	long long loop_start=getSystemTime();

	long long start=getSystemTime();
	long long end;
	
	int i, j;
	while(i<2000000){
		
		reply = redisCommand(c, "RPOP %s", "clist");
		
		if(strlen(reply->str)==0){
			freeReplyObject(reply);	
			break;
		}

		freeReplyObject(reply);	

		i++;		

		if(j>=10000){

			j=0;
			end=getSystemTime();			
			printf("10000 pop time cost: %lld ms\n", end-start);
			start=getSystemTime();

		}
		
		j++;

	}
	
	long long loop_end=getSystemTime();
	printf("total time: %lld ms\n", loop_end-loop_start);
	
	return 0;
}
#include "critical.h"

double calc(int n, int myid, int numprocs ){
		double sum, h, x;
		int i;
		h   = 1.0 / (double) n;
        sum = 0.0;
        for (i = myid + 1; i <= n; i += numprocs){
                x = h * ((double)i - 0.5);
                sum += (4.0 / (1.0 + x*x));
		}
		return  h * sum; 
}

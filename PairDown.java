
public class PairDown {
	public int[] fold(int[] list) {
	int nlen = list.length/2 ; 
	if(list.length%2 == 1) {
		nlen += 1;
	}
	int[] ret = new int [nlen] ;
	int index = 0;
	for(int k=0 ; k< list.length -1 ; k+= 2) {
		ret[index] = list[k]+ list[k+1];
		index+= 1;
	}
	if(list.length %2 ==1) {
		ret[index] = list[list.length-1];
	}
	return ret;
	}
}
	 


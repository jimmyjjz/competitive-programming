import java.util.*;
import java.io.*;
public class box{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
   public static void main (String[] args) throws IOException{
	int length = 0;
	int width = 0;
	int height = 0;
	int index = 0;
	int m = 0;
	Boxes now;
	int n = readInt();
	Boxes[] prism = new Boxes [n];
	for (int i = 0; i<n; i++){
	    length = readInt(); width = readInt(); height = readInt();
	    prism[i] = new Boxes (length, width, height);
	}
	for (int k = 1; k<n; k++){
		index = k - 1;
	    now = prism[k];
	    while (index >= 0 && prism[index].v > now.v){
		prism[index + 1] = prism[index];
		index--;
	    }
	    prism[index + 1] = now;
	}
	m = readInt ();
	for (int i = 0; i<m; i++){
	    length = readInt(); width = readInt(); height = readInt();
	    now = new Boxes(length, width, height);
	    index = 0;
	    while (index < n && (now.length > prism[index].length || now.width > prism[index].width || now.height > prism[index].height)) {
	    	index++;
	    }
	    if (index < n) {
	    System.out.println (prism[index].v);
	    }
	    else {
		System.out.println ("Item does not fit.");
	    }
	}
    }
static String next () throws IOException {
	while (st == null || !st.hasMoreTokens())
		st = new StringTokenizer(br.readLine().trim());
	return st.nextToken();
}
static long readLong () throws IOException {
	return Long.parseLong(next());
}
static int readInt () throws IOException {
	return Integer.parseInt(next());
}
static double readDouble () throws IOException {
	return Double.parseDouble(next());
}
static char readCharacter () throws IOException {
	return next().charAt(0);
}
static String readLine () throws IOException {
	return br.readLine().trim();
}
}
class Boxes{
    public int length, width, height;
    public long v;
    public Boxes (int a, int b, int c){
	int keep = 0;
	length = a;
	width = b;
	height = c;
	if (length > width){
	    keep = length;
	    length = width;
	    width = keep;
	}
	if (width > height){
	    keep = width;
	    width = height;
	    height = keep;
	}
	if (length > width){
	    keep = length;
	    length = width;
	    width = keep;
	}
	v = length * width * height;
    }
}
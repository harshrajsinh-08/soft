public class euler {
    static int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }
    static int ph(int n){
        int res=1;
        for(int i=2;i<n;i++){
            if(gcd(i,n)==1){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2000;
        System.out.println(ph(n));
    }
}

package ArrayPractice;

public class array {
    
    public static void main(String [] args)
    {
        System.out.print("hello");
        int []arr={1,2,3,4,5,6,7,8,9,0};
        int count=1;
        String str="";
        for(int i=0;i<arr.length;i++)
        {
            
            if(count==0)
            {
                count = i+1;
                System.out.println(str);
                str="";
            }
            else
            {
                str+=Integer.toString(arr[i]);
                count = count-1;
            }
            
        }
        System.out.println(str);
    }

}

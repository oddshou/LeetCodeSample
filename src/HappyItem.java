import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * 输入: 19
 * 输出: true
 * 解释:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
class HappyItem {


    public static boolean isHappy(int n) {
        int result = n;
        HashSet<Integer> resultSet = new HashSet<Integer>();
        do{
            result = sum2(result);
            if (!resultSet.add(result)) {
                break;
            }
        }while (result != 1);
        return result == 1;
    }

    //优解
    public static int sum2(int n) {
        int num = 0;
        while(n > 0){
            num = num + (n%10) * (n%10);
            n /= 10;
        }
        return num;
    }

    public static int sum(int n) {
        //先判断有多少位，10000
        long k = 1;
        int i = 0;
        while (n >= k) {
            k *= 10;
            i++;
        }
        int sum = 0;
        for (int j = i; j > 0; j--) {
            sum += (n / (int)Math.pow(10, j-1) % 10)*(n / (int)Math.pow(10, j-1)  % 10);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(
                1880803623));
    }
}

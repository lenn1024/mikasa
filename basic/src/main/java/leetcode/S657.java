package leetcode;

/**
 * 机器人回到原点
 */
public class S657 {

    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for(int i = 0; i < moves.length(); i++){
            char move = moves.charAt(i);
            switch (move){
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                default:
                    break;
            }
        }

        if(x == 0 && y == 0){
            return true;
        }

        return false;
    }
}

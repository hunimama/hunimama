package algorithm;

/**
 * @author 794073612@qq.com
 * @time 9:04 2022/6/15
 **/
public class Mouse {
    public static int ExitX = 8;
    public static int ExitY = 10;
    public static int[][] MAZE = {
            {1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,1,1,1,1,1,1,1},
            {1,1,1,0,1,1,0,1,1,0,1,1},
            {1,1,1,0,0,0,0,1,1,0,1,1},
            {1,1,1,0,1,1,0,1,1,0,1,1},
            {1,1,1,1,1,1,0,1,1,0,1,1},
            {1,1,0,0,0,0,0,0,1,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1}
    };

    public static void main(String[] args) throws Exception{
        int i, j, x, y;
        TraceRecord path = new TraceRecord();
        x = 1;
        y = 1;
        System.out.println("迷宫路径");
        for (i = 0; i < 10; i++){
            for (j = 0; j < 12; j++){
                System.out.print(MAZE[i][j]);
                System.out.print("\n");
            }
        }
        while (x <= ExitX && y <= ExitY){
            MAZE[x][y] = 2;
            if(MAZE[x - 1][y] == 0){
                x -= 1;
                path.insert(x, y);
            }
            else if(MAZE[x + 1][y] == 0){
                x += 1;
                path.insert(x, y);
            }else if(MAZE[x][y - 1] == 0){
                y -= 1;
                path.insert(x, y);
            }else if(MAZE[x][y + 1] == 0){
                y += 1;
                path.insert(x, y);
            }else if (chkExit(x,y,ExitX,ExitY) == 1){
                break;
            }else{
                MAZE[x][y] = 2;
                path.delete();
                x = path.last.x;
                y = path.last.y;
            }
        }
        System.out.println("老鼠路径");
        for (i = 0; i < 10; i++){
            for (j = 0; j < 12; j++){
                System.out.print(MAZE[i][j]);
                System.out.print("\n");
            }
        }
    }

    private static int chkExit(int x, int y, int exitX, int exitY) {
        if (x == exitX && y == exitY){
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 2){
                return 1;
            }
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 2 || MAZE[x][y + 1] == 1){
                return 1;
            }
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 2 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 1){
                return 1;
            }
            if (MAZE[x - 1][y] == 2 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 1){
                return 1;
            }
        }
        return 0;
    }
}

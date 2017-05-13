import java.util.*;


class Othello {
	// ボード 0:空,1:user,2:cpu
	int bord[][];
	private static final int WALL = -1, EMPTY =  0, ME = 1, CPU = 2;

	// コンストラクタ
	Othello(){
		// 配列bordの初期化
		this.bord = new int[10][10];
		int bord[][] = {
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1,0,0,0,0,0,0,0,0,-1},
			{-1,0,0,0,0,0,0,0,0,-1},
			{-1,0,0,0,0,0,0,0,0,-1},
			{-1,0,0,0,1,2,0,0,0,-1},
			{-1,0,0,0,2,1,0,0,0,-1},
			{-1,0,0,0,0,0,0,0,0,-1},
			{-1,0,0,0,0,0,0,0,0,-1},
			{-1,0,0,0,0,0,0,0,0,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		};
		this.bord = bord;
	}

	public static void main(String[] args) {
		Othello othello = new Othello();
		int move[];

		// while(1){
			othello.write();
			move = othello.userInput();
			//othello.turnStone();
			//othello.write();
			// move = cpu();
			// turnStone(move);
		// }
	}

	// Userの入力を受け取る
	public int[] userInput() {
		System.out.print("please input like 3a. >  ");
		Scanner sc = new Scanner(System.in);
		String move = sc.next();

		int[] ret = {0,0};

		char rowName[] = {'a','b','c','d','e','f','g','h'};
		Map<Character,Integer> row_num = new HashMap<Character,Integer>();
		int counter = 1;
		for(char name :rowName){
			row_num.put(name,counter);
			counter++;
		}
		try{
			ret[0] = Character.getNumericValue(move.charAt(0));
			ret[1] = row_num.get(move.charAt(1));
		}catch(NullPointerException e){	ret = userInput();	}
		if((ret[0] < 1 || 8 < ret[0] ) || (ret[1] < 1 || 8 < ret[1] )) {
			ret = userInput();
		}
		if(!putCheck(ret,ME)){
			ret = userInput();
		}

		return ret;

	}
	// CPUの手を返す
	//public String cpu(){}
	// 石をひっくり返せるかcheck
	public boolean putCheck(int move[],int player) {
		int[][] dir = {{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1},{-1,0}};
		int row = move[0];
		int colum = move[1];
		// 置き場所が空か
		if (bord[row][colum] != EMPTY) {	return false;	}

		// ひっくり返せるか
		for(int i = 0; i < dir.length; i++) {
			int X = dir[i][0];
			int Y = dir[i][1];
			int tmpRow = row;
			int tmpColum = colum;
			boolean flag = false;
			while(bord[tmpRow][tmpColum] >= 0){
				if (bord[tmpRow += X][tmpColum += Y] == 3 - player) {
					flag = true;
				}
				else if (flag && (bord[tmpRow][tmpColum] == player)) {
					return true;
				}else
					break;
			}
		}
		return false;
	}



	// ボードを表示する
	public void write(){
		char rowName[] = {' ','a','b','c','d','e','f','g','h','\n'};

		for (char c: rowName) {
			System.out.print(" " + c );
		}

		for (int i=1; i<9; i++) {
			System.out.print(i + " ");
			for (int j=1; j<9; j++){
				if(bord[i][j] == EMPTY)
					System.out.print(" *");
				else if (bord[i][j] == ME) 
					System.out.print(" ○");
				else
					System.out.print(" ×");
			}
			System.out.println("");
		}


	}
}

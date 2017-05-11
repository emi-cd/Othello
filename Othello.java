


class Othello {
	// ボード 0:空,1:user,2:cpu
	String bord[][] = new String[8][9];

	// コンストラクタ
	Othello(){
		// 配列bordの初期化
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++){
				if ((i == 3 && j == 4) || (i == 4 && j == 3))
					bord[i][j] = "○";
				else if ((i == 3 && j == 3) || (i == 4 && j == 4))
					bord[i][j] = "";
				else
					bord[i][j] = "*";
			}
			bord[i][8] = "\n";
		}
	}

	public static void main(String[] args) {
		Othello othello = new Othello();

		// while(1){
			othello.write();
			// move = userInput();
			// turnStone(move);
			// mpve = cpu();
			// turnStone(move);
		// }
	}

	// Userの入力を受け取る
	//public String userInput(){}
	// CPUの手を返す
	//public String cpu(){}
	// 石をひっくり返す
	// public void turnStone(String move){}


	// ボードを表示する
	public void write(){
		char rowName[] = {' ','a','b','c','d','e','f','g','h','\n'};

		for (char c: rowName) {
			System.out.print(" " + c );
		}

		for (int i=0; i<8; i++) {
			System.out.print((i+1) + " ");
			for (int j=0; j<9; j++){
				System.out.print(" " + bord[i][j]);
			}
		}


	}
}

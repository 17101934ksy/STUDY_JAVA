package queen;

public class EightQueen {

    static boolean[] flagRow = new boolean[8];
    static boolean[] flagLDown = new boolean[15];
    static boolean[] flagRDown = new boolean[15];
    static int[] pos = new int[8];
    static int count;

    static void setQueen(int i) {
        for (int j = 0; j < 8; j++) {
            if (!flagRow[j] && !flagLDown[i + j] && !flagRDown[i - j + 7]) {
                pos[i] = j; // i 행에 j번 열

                if (i == 7) {
                    count++;
                    for (int k = 0; k < pos.length; k++) System.out.printf("%2d", pos[k]);
                    System.out.println();
                }

                else {
                    flagRow[j] = flagLDown[i + j] = flagRDown[i - j + 7] = true;
                    setQueen(i + 1);
                    flagRow[j] = flagLDown[i + j] = flagRDown[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        setQueen(0);
        System.out.println("count = " + count);
    }

}

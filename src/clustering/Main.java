//package clustering;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.List;
//import java.util.StringTokenizer;
//
//import static java.lang.Integer.parseInt;
//
//public class Main {
//
//    static int n;
//    static int k;
//    static int[] center; //result
//    static int[][] point;
//
//    static double[] distances;
//
//    static List<double[]> distancesList;
//
//    static double maxDistanceInstance;
//    static boolean flag;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//
//        n = parseInt(stringTokenizer.nextToken());
//        k = parseInt(stringTokenizer.nextToken());
//
//        point = new int[n][2];
//        center = new int[k];
//
//
//        for (int i=0; i<n; i++) {
//            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//            point[i][0] = parseInt(stringTokenizer.nextToken());
//            point[i][1] = parseInt(stringTokenizer.nextToken());
//        }
//
//        //k = 1
//        center[0] = 0;
//
//        //k = 2
//        distancesList.add(new double[2]);
//
//        for (int i=0; i<n; i++) {
//
//            for (int j=0; j<k; j++) {
//
//                if (center[j] == i) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            if (flag) {
//                for (int j=0; j<k; j++) {
//                    getDistance(center[j], i);
//                    distancesList.get(0)[j] =
//                }
//            }
//
//        }
//
//
//
//    }
//
//    private static void maxDistance(int i, int j) {
//        distancesList.get(i)[j] = Math.max(distancesList.get(i)[j], maxDistanceInstance);
//    }
//
//
//    /**
//     * 모인 distance에서 최소값 선택
//     */
//    private static void minDistance(int i) {
//        distances[i] = distancesList.get(i)[0];
//
//        for (int j=1; j<distancesList.get(i).length; j++) {
//            distances[i] = Math.min(distances[i], distancesList.get(i)[j]);
//        }
//
//    }
//
//    // i 센터 선택, point
//    private static double getDistance(int i, int j) {
//        return Math.max(maxDistanceInstance, Math.sqrt(Math.pow(point[i][0] - point[j][0], 2) + Math.pow(point[i][1] - point[j][1], 2)));
//    }
//
//}

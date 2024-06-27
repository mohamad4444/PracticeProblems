

import java.util.Arrays;
import java.util.LinkedList;

public class KnightsTour {
/*
 * This code seems to aim at solving the Knight's Tour problem,
 *  where a knight visits every square on a chessboard
 *  exactly once following the rules of chess movement.
 */
	static LinkedList<int[][]> solutions = new LinkedList<>();

	public static void moveHorse(int[][] visited, int[] pos) {
		int n = visited.length;
		int[][] visited2=new int[visited.length][visited.length];
		int count = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited2[i][j]=visited[i][j];
				if (count < visited[i][j]) {
					count = visited[i][j];
				}
			}
		}
		if (count ==30) {
			solutions.add(visited);
		}
		LinkedList<int[]> nextMoves = new LinkedList<>();
		LinkedList<int[]> validMoves = new LinkedList<>();
		nextMoves.add(new int[] { pos[0] + 2, pos[1] + 1 });
		nextMoves.add(new int[] { pos[0] + 2, pos[1] - 1 });
		nextMoves.add(new int[] { pos[0] + 1, pos[1] + 2 });
		nextMoves.add(new int[] { pos[0] + 1, pos[1] - 2 });
		nextMoves.add(new int[] { pos[0] - 1, pos[1] + 2 });
		nextMoves.add(new int[] { pos[0] - 1, pos[1] - 2 });
		nextMoves.add(new int[] { pos[0] - 2, pos[1] + 1 });
		nextMoves.add(new int[] { pos[0] - 2, pos[1] - 1 });
		for (int[] move : nextMoves) {
			if (move[0] >= 0 && move[0] < n && move[1] >= 0 && move[1] < n) {
				if (visited[move[0]][move[1]] == 0) {
					validMoves.add(move);
				}
			}
		}
		for (int[] validMove : validMoves) {
			visited2=new int[visited.length][visited.length];
			 count = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited2[i][j]=visited[i][j];
					if (count < visited[i][j]) {
						count = visited[i][j];
					}
				}
			}
			visited2[validMove[0]][validMove[1]] = count+1;
			moveHorse(visited2, validMove);
		}
	}

	public static void main(String[] args) {
		int[][] visited = new int[6][6];
		visited[0][0] = 1;
		moveHorse(visited, new int[] { 0, 0 });
		System.out.println(solutions.size());
		System.out.println(Arrays.deepToString(solutions.get(0)));
		System.out.println(Arrays.deepToString(solutions.get(1)));
	}
}
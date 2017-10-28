/**
 * 
 * @author Sagar Rathod
 * @version 1.0
 */
public class RobotSimulator {

	enum Direction {

		NORTH, EAST, SOUTH, WEST;

		Direction left, right;

		public void setLeft(Direction left) {
			this.left = left;
		}

		public void setRight(Direction right) {
			this.right = right;
		}

		public Direction getLeft() {
			return left;
		}

		public Direction getRight() {
			return right;
		}
	}

	final static Direction NORTH = Direction.NORTH;
	final static Direction EAST = Direction.EAST;
	final static Direction SOUTH = Direction.SOUTH;
	final static Direction WEST = Direction.WEST;

	static void initSimulator() {
		
		NORTH.setLeft(Direction.WEST);
		NORTH.setRight(Direction.EAST);

		EAST.setLeft(Direction.NORTH);
		EAST.setRight(Direction.SOUTH);

		SOUTH.setLeft(Direction.EAST);
		SOUTH.setRight(Direction.WEST);

		WEST.setLeft(Direction.SOUTH);
		WEST.setRight(Direction.NORTH);

	}

	static class Robot {

		private int x;
		private int y;
		private Direction faceDirection;

		public Robot(int x, int y, Direction faceDirection) {
			
			this.x = x;
			this.y = y;
			this.faceDirection = faceDirection;
		}

		public void advance() {

			if (faceDirection == Direction.EAST)
				x++;

			if (faceDirection == Direction.WEST)
				x--;

			if (faceDirection == Direction.NORTH)
				y++;

			if (faceDirection == Direction.SOUTH)
				y--;
		}

		public void turnLeft() {
			faceDirection = faceDirection.getLeft();
		}

		public void turnRight() {
			faceDirection = faceDirection.getRight();
		}

		@Override
		public String toString() {
			return "Robot is standing at (x, y) =" + " (" + x + ", " + y + ") position facing " + faceDirection
					+ " direction.";
		}

		/**
		 * Simulates robot walking path.
		 * 
		 * @param path
		 */
		public void simulateRobotWalkingPath(String path) {

			System.out.println("Initial Position:" + this);
			char[] chars = path.toCharArray();

			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == 'R') {
					turnRight();
				}

				if (chars[i] == 'L') {
					turnLeft();
				}

				if (chars[i] == 'A') {
					advance();
				}
			}
			System.out.println("Final Position:" + this);
		}
	}

	public static void main(String[] args) {

		initSimulator();
		Robot robot = new Robot(7, 3, NORTH);
		robot.simulateRobotWalkingPath("RAALAL");

		robot = new Robot(4, 5, SOUTH);
		robot.simulateRobotWalkingPath("LAARALL");
	}

}

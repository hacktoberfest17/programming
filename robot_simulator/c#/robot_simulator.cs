using System;

namespace robot_simulator
{
    class MainClass
    {
        public static void Main(string[] args)
        {
            Robot r = new Robot(7, 3, "north", "RAALAL");
            r.run();
        }
    }

    enum CardinalDirections {north, east, south, west}

    class Robot
    {
        private int x { get; set; }
        private int y { get; set; }
        private CardinalDirections bearing { get; set; }
        private string instructions { get; set; }

        public Robot(int x0, int y0, string bearing, string instructions)
        {
            x = x0;
            y = y0;
            this.instructions = instructions;

            if (bearing.ToLower().Equals("north"))
                this.bearing = CardinalDirections.north;
            else if (bearing.ToLower().Equals("east"))
                this.bearing = CardinalDirections.east;
            else if (bearing.ToLower().Equals("south"))
                this.bearing = CardinalDirections.south;
            else
                this.bearing = CardinalDirections.west;
        }

        private void advance()
        {
            switch (bearing)
            {
                case CardinalDirections.north:
                    y++;
                    break;
                case CardinalDirections.east:
                    x++;
                    break;
                case CardinalDirections.south:
                    y--;
                    break;
                case CardinalDirections.west:
                    x--;
                    break;
            }
        }

        private void turn(char dir)
        {
            int currentBearing = (int)bearing;
            if (dir == 'R' || dir == 'r')
                bearing = (CardinalDirections)((currentBearing + 1) % 4);
            else
                bearing = (CardinalDirections)((currentBearing - 1) % 4);

            if ((int)bearing < 0)
                bearing = (CardinalDirections)((int)bearing + 4);
        }

        public void run()
        {
            foreach (char c in instructions)
            {
                if (c == 'A' || c == 'a')
                    advance();
                else
                    turn(c);
            }
            Console.WriteLine("Final Position: (" + x + "," + y + ")");
            Console.WriteLine("Final Bearing: " + bearing.ToString());
        }
    }
}

package task;

public enum Direction {
    North{
        public Vector2 move(Vector2 start, double distance){
            return new Vector2(start.getX()+0,start.getY()-distance);
        }
    },
    West{
        public Vector2 move(Vector2 start, double distance){
            return new Vector2(start.getX()-distance,start.getY()+0);
        }
    },
    South{
        public Vector2 move(Vector2 start, double distance){
            return new Vector2(start.getX()+0,start.getY()+distance);
        }
    },
    East{
        public Vector2 move(Vector2 start, double distance){
            return new Vector2(start.getX()+distance,start.getY()+0);
        }
    };


   public abstract Vector2 move(Vector2 start, double distance);

}

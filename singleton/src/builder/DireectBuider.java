package builder;

public class DireectBuider {

    /*public DireectBuider( HouseBuilder builder ){
          builder.makeFloor();
          builder.makeWall();
    }*/

    public void makeHouse(HouseBuilder builder){
        builder.makeFloor();
        builder.makeWall();
    }

}

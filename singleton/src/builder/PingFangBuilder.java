package builder;

public class PingFangBuilder implements HouseBuilder {

    House house = new House();

    @Override
    public void makeFloor() {
        house.setFloor("平顶");
    }

    @Override
    public void makeWall() {
         house.setWall("平强");
    }

    @Override
    public House getHouse() {
        return house;
    }
}

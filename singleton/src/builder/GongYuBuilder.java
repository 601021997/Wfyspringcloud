package builder;

public class GongYuBuilder implements HouseBuilder {

    House house = new House();

    @Override
    public void makeFloor() {
          house.setFloor("公寓屋顶");
    }

    @Override
    public void makeWall() {
          house.setWall("公寓墙");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
